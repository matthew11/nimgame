/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameplayer.nimgame.standard;

import gameplayer.nimgame.standard.events.NimGameStepEvent;
import gameplayer.nimgame.standard.exceptions.NimGameInvalidStepException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import gameplayer.gameengine.AbstractGameSettings;
import gameplayer.gameengine.Player;
import gameplayer.gameengine.StepObject;
import gameplayer.gameengine.eventmanager.EventChannelInvalidException;
import gameplayer.gameengine.events.GameErrorEvent;
import gameplayer.gameengine.events.GameEvent;
import gameplayer.gameengine.exceptions.GameException;
import gameplayer.gameengine.exceptions.GameSettingsInvalidException;
import gameplayer.gameengine.exceptions.GameSetupIncompleteException;
import gameplayer.gameengine.exceptions.PlayerAlreadyRegisteredException;
import gameplayer.gameengine.exceptions.PlayerListFullException;
import gameplayer.gameengine.turnbased.TurnBasedGame;
import gameplayer.gameengine.turnbased.exceptions.PlayerOrderException;
import gameplayer.nimgame.standard.events.NimGameTurnEvent;

/**
 *
 * @author Máté Pozsgay
 */
public class NimGameCore extends TurnBasedGame implements NimPlayerController {

    public static final int MAX_PLAYER_COUNT = 2;
    public static final int MIN_PLAYER_COUNT = 2;
    public static final int MAX_HEAP_COUNT = 100;
    public static final int MIN_HEAP_COUNT = 1;
    public static final int MAX_ENTITY_COUNT = 999;
    public static final int MIN_ENTITY_COUNT = 0;
    public static final int MAX_RANDOM_HEAP_COUNT = 6;
    public static final int MIN_RANDOM_HEAP_COUNT = 2;
    public static final int MAX_RANDOM_ENTITY_COUNT = 20;
    public static final int MIN_RANDOM_ENTITY_COUNT = 5;

    private List<Integer> heapConfiguration = new ArrayList<>();
    private NimGameSettings nimGameSettings;

    private final Random random = new Random();
    private boolean misereNimGame = true;

    public NimGameCore() throws EventChannelInvalidException {
        super();
    }

    private int getIntBetween(int boundaryA, int boundaryB) {
        if (boundaryA == boundaryB) {
            return boundaryA;
        }
        if (boundaryA > boundaryB) {
            int temp = boundaryB;
            boundaryB = boundaryA;
            boundaryA = temp;
        }
        return random.nextInt(boundaryB - boundaryA) + boundaryA;
    }

    private void validateRandomSettings(int minHeapCount, int maxHeapCount, int minEntityCount, int maxEntityCount) throws GameSettingsInvalidException {
        if (minHeapCount < MIN_HEAP_COUNT || maxHeapCount > MAX_HEAP_COUNT
                || minEntityCount < MIN_ENTITY_COUNT || maxEntityCount > MAX_ENTITY_COUNT) {
            throw new GameSettingsInvalidException("Random configuration is invalid.");
        }
    }

    private NimPlayer instantiatePlayer(NimPlayerSettings playerSettings) {
        NimPlayer player;
        if (playerSettings.isIsAI()) {
            player = new NimAIPlayer(playerSettings.getPlayerID(), playerSettings.getPlayerName(), this);
        } else {
            player = new NimHumanPlayer(playerSettings.getPlayerID(), playerSettings.getPlayerName(), this);
        }
        if (playerSettings.isStarter()) {
            this.currentPlayer = player;
        }
        return player;
    }

    @Override
    public void loadGameSettings(AbstractGameSettings gameSettings) throws GameSettingsInvalidException, PlayerAlreadyRegisteredException, PlayerListFullException {
        int heapCount, minHeapCount = 0, maxHeapCount = 0, minEntityCount = 0, maxEntityCount = 0;
        nimGameSettings = (NimGameSettings) gameSettings;
        this.misereNimGame = nimGameSettings.isMisereNimGame();
        this.players.clear();
        for (NimPlayerSettings playerSettings : nimGameSettings.getPlayers()) {
            registerPlayer(instantiatePlayer(playerSettings));
        }
        switch (nimGameSettings.getConfigType()) {
            case CONFIG_TYPE_CUSTOM: {
                List<Integer> heapConfiguration = nimGameSettings.getHeapConfiguration();
                if (heapConfiguration.size() < MIN_HEAP_COUNT || heapConfiguration.size() > MAX_HEAP_COUNT) {
                    throw new GameSettingsInvalidException("Heap count does not satisfy heap count rules: " + MIN_HEAP_COUNT + " <= " + heapConfiguration.size() + " <= " + MAX_HEAP_COUNT);
                }
                for (int i : heapConfiguration) {
                    if (i < MIN_ENTITY_COUNT || i > MAX_ENTITY_COUNT) {
                        throw new GameSettingsInvalidException("Number '" + i + "' does not satisfy entity count rules: " + MIN_ENTITY_COUNT + " <= " + i + " <= " + MAX_ENTITY_COUNT);
                    }
                }
                this.heapConfiguration = new ArrayList<>(heapConfiguration);
                return;
            }
            case CONFIG_TYPE_RANDOM: {
                minHeapCount = MIN_RANDOM_HEAP_COUNT;
                maxHeapCount = MAX_RANDOM_HEAP_COUNT;
                minEntityCount = MIN_RANDOM_ENTITY_COUNT;
                maxEntityCount = MAX_RANDOM_ENTITY_COUNT;
                break;
            }
            case CONFIG_TYPE_CONTROLLED_RANDOM: {
                minHeapCount = nimGameSettings.getMinHeapCount();
                maxHeapCount = nimGameSettings.getMaxHeapCount();
                minEntityCount = nimGameSettings.getMinEntityCount();
                maxEntityCount = nimGameSettings.getMaxEntityCount();
                break;
            }
        }
        validateRandomSettings(minHeapCount, maxHeapCount, minEntityCount, maxEntityCount);
        heapCount = getIntBetween(minHeapCount, maxHeapCount);
        for (int i = 0; i < heapCount; i++) {
            heapConfiguration.add(getIntBetween(minEntityCount, maxEntityCount));
        }
    }

    @Override
    public void registerPlayer(Player player) throws PlayerAlreadyRegisteredException, PlayerListFullException {
        if (players.contains(player)) {
            throw new PlayerAlreadyRegisteredException("Player " + player.getName() + "already joined to the game");
        }
        if (players.size() > NimGameCore.MAX_PLAYER_COUNT) {
            throw new PlayerListFullException("No more room for other players. Player " + player.getName() + " was unable to join to the game. Maximum allowed number of players: " + NimGameCore.MIN_PLAYER_COUNT);
        }
        super.registerPlayer(player);
    }

    @Override
    public void nextStep(final StepObject step) throws PlayerOrderException, GameException {
        if (!(step instanceof NimStepObject)) {
            throw new GameException("Invalid step object. This step object " + step.getClass().getName() + "is not belongs to Nim game!");
        }
        NimStepObject nimStep = (NimStepObject) step;
        if (nimStep.amount <= 0) {
            throw new GameException("Invalid amount. At least one entity must be removed from a heap");
        }
        validatePlayer(step.getOriginatingPlayer());
        decreaseEntityBy(nimStep.getHeapID(), nimStep.getAmount());
        stepHistory.add(step);
        eventChannel.dispatchEvent(new NimGameStepEvent(this, nimStep));
        if (isInEndState()) {
            eventChannel.dispatchEvent(new GameEvent(this, GameEvent.EVENT_GAME_ENDED));
            return;
        }
        System.out.println("Heap config: " + heapConfiguration);
        nextTurn(currentPlayer);
    }

    @Override
    public void nextTurn(Player originatingPlayer) throws PlayerOrderException {
        super.nextTurn(originatingPlayer);
        eventChannel.dispatchEvent(new NimGameTurnEvent(this, currentPlayer));
        try {
            ((NimPlayer) (this.currentPlayer)).notifyYourTurn();
        } catch (GameException ex) {
            eventChannel.dispatchEvent(new GameErrorEvent(this, ex));
        }
    }

    @Override
    public void undoStep() {
        NimStepObject lastStep = (NimStepObject) stepHistory.get(stepHistory.size() - 1);
        heapConfiguration.set(lastStep.getHeapID(), heapConfiguration.get(lastStep.getHeapID()) + lastStep.getAmount());
        this.currentPlayer = getPreviousPlayer(lastStep.getOriginatingPlayer());
        stepHistory.remove(lastStep);
    }

    public int getHeapCount() {
        return heapConfiguration.size();
    }

    public int getHeapValue(final int heapID) {
        return heapConfiguration.get(heapID);
    }

    private void decreaseEntityBy(final int heapID, final int amount) throws GameException {
        int currentValue = heapConfiguration.get(heapID);
        if (amount > currentValue) {
            throw new NimGameInvalidStepException("Cannot decrease entity on heap " + heapID + "(" + currentValue + ") by " + amount + ". Insufficient entity count");
        }
        heapConfiguration.set(heapID, currentValue - amount);
    }

    @Override
    public boolean isInEndState() {
        return heapConfiguration.stream().noneMatch((i) -> (i > 0));
    }

    @Override
    public Player getWiningPlayer() {
        if (misereNimGame) {
            return getNextPlayer();
        } else {
            return currentPlayer;
        }
    }

    @Override
    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public void startGame() throws GameSetupIncompleteException {
        if (players.size() != NimGameCore.MIN_PLAYER_COUNT) {
            throw new GameSetupIncompleteException("Not enough player joined to the game. Current player count: " + players.size() + " Minimum player count: " + NimGameCore.MIN_PLAYER_COUNT);
        }
        if (currentPlayer == null) {
            currentPlayer = players.get(0);
        }
        super.startGame();
        try {
            ((NimPlayer) (this.currentPlayer)).notifyYourTurn();
        } catch (GameException ex) {
            eventChannel.dispatchEvent(new GameErrorEvent(this, ex));
        }
    }

    @Override
    public int getMaxPlayers() {
        return NimGameCore.MAX_PLAYER_COUNT;
    }

    @Override
    public void stopGame() {
        deregisterAllPlayers();
        super.stopGame();
    }

    public void deregisterAllPlayers() {
        while (!players.isEmpty()) {
            players.get(0).stop();
            players.remove(0);
        }
    }

    @Override
    public List<Integer> getHeapConfiguration() {
        return new ArrayList<>(heapConfiguration);
    }

    @Override
    public AbstractGameSettings getGameSettings() {
        return nimGameSettings;
    }

}
