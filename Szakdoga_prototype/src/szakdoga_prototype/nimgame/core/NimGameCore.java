/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szakdoga_prototype.nimgame.core;

import szakdoga_prototype.nimgame.core.exceptions.NimGameInvalidStepException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import szakdoga_prototype.gameengine.Player;
import szakdoga_prototype.gameengine.StepObject;
import szakdoga_prototype.gameengine.exceptions.GameException;
import szakdoga_prototype.gameengine.exceptions.GameSetupIncompleteException;
import szakdoga_prototype.gameengine.exceptions.PlayerAlreadyRegistered;
import szakdoga_prototype.gameengine.exceptions.PlayerListFull;
import szakdoga_prototype.gameengine.turnbased.TurnBasedGame;
import szakdoga_prototype.gameengine.turnbased.exceptions.PlayerOrderException;

/**
 *
 * @author matthew
 */
public class NimGameCore extends TurnBasedGame {

    private static final int MAX_PLAYER_COUNT = 2;
    private static final int MIN_PLAYER_COUNT = 2;
    private static final int MAX_HEAP_COUNT = 6;
    private static final int MIN_HEAP_COUNT = 2;
    private static final int MAX_ENTITY_COUNT = 20;
    private static final int MIN_ENTITY_COUNT = 5;

    private List<Integer> heapConfiguration;

    private final Random random;

    private int getIntBetween(final int min, final int max) {
        return random.nextInt(max - min) + min;
    }

    public NimGameCore(int heapCount, final int minEntity, final int maxEntity) {
        this.random = new Random();
        heapConfiguration = new ArrayList<>();
        if (heapCount == 0) {
            heapCount = getIntBetween(MIN_HEAP_COUNT, MAX_HEAP_COUNT);
        }
        for (int i = 0; i < heapCount; i++) {
            heapConfiguration.add(getIntBetween(minEntity, maxEntity));
        }
    }

    public NimGameCore() {
        this(0, NimGameCore.MIN_ENTITY_COUNT, NimGameCore.MAX_ENTITY_COUNT);
    }

    @Override
    public void registerPlayer(NimPlayer player) throws PlayerAlreadyRegistered, PlayerListFull {
        if (players.contains(player)) {
            throw new PlayerAlreadyRegistered("Player " + player.getName() + "already joined to the game");
        }
        if (players.size() > NimGameCore.MAX_PLAYER_COUNT) {
            throw new PlayerListFull("No more room for other players. Player " + player.getName() + " was unable to join to the game. Maximum allowed number of players: " + NimGameCore.MIN_PLAYER_COUNT);
        }
        super.registerPlayer(player);
    }

    @Override
    public void nextStep(final NimStepObject step) throws PlayerOrderException, GameException {
        validatePlayer(step.getOriginatingPlayer());
        decreaseEntityBy(step.getHeapID(), step.getAmount());
        nextTurn(currentPlayer);
    }

    @Override
    public void nextStep(final StepObject step) throws PlayerOrderException, GameException {
        nextStep((NimStepObject) step);
        nextTurn(step.getOriginatingPlayer());
    }

    public int getHeapCount() {
        return heapConfiguration.size();
    }

    public int getHeapValue(final int heapID) {
        return heapConfiguration.get(heapID);
    }

    public void decreaseEntityBy(final int heapID, final int amount) throws GameException {
        int currentValue = heapConfiguration.get(heapID);
        if (amount > currentValue) {
            throw new NimGameInvalidStepException("Cannot decrease entity on heap " + heapID + "(" + currentValue + ") by " + amount + ". Insufficient entity count");
        }
        heapConfiguration.set(heapID, currentValue - amount);
    }

    @Override
    public boolean isInEndState() {
        return heapConfiguration.isEmpty();
    }

    @Override
    public Player getWiningPlayer() {
        return currentPlayer;
    }

    @Override
    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public void startGame() throws GameSetupIncompleteException {
        if (players.size() != NimGameCore.MIN_PLAYER_COUNT) {
            throw new GameSetupIncompleteException("Not enough player joined to the game. Current player count: " + players.size() + " Minimum player count: " + NimGameCore.MIN_HEAP_COUNT);
        }
        currentPlayer = players.get(0);
    }

    @Override
    public int getMaxPlayers() {
        return NimGameCore.MAX_PLAYER_COUNT;
    }

    public void stopGame() {
        deregisterAllPlayers();
    }

    public void deregisterAllPlayers() {
        while (!players.isEmpty()) {
            players.get(0).stop();
            players.remove(0);
        }
    }

}
