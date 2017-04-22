/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szakdoga_prototype.nimgame.core;

import szakdoga_prototype.nimgame.core.exceptions.NimGameInvalidStepException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import szakdoga_prototype.gameengine.Player;
import szakdoga_prototype.gameengine.StepObject;
import szakdoga_prototype.gameengine.exceptions.GameException;
import szakdoga_prototype.gameengine.exceptions.GameSettingInvalidException;
import szakdoga_prototype.gameengine.exceptions.GameSetupIncompleteException;
import szakdoga_prototype.gameengine.exceptions.PlayerAlreadyRegisteredException;
import szakdoga_prototype.gameengine.exceptions.PlayerListFullException;
import szakdoga_prototype.gameengine.turnbased.TurnBasedGame;
import szakdoga_prototype.gameengine.turnbased.exceptions.PlayerOrderException;

/**
 *
 * @author matthew
 */
public class NimGameCore extends TurnBasedGame {

    public static final int MAX_PLAYER_COUNT = 2;
    public static final int MIN_PLAYER_COUNT = 2;
    public static final int MAX_HEAP_COUNT = 10;
    public static final int MIN_HEAP_COUNT = 1;
    public static final int MAX_ENTITY_COUNT = 100000;
    public static final int MIN_ENTITY_COUNT = 1;

    private static final int MAX_RANDOM_HEAP_COUNT = 6;
    private static final int MIN_RANDOM_HEAP_COUNT = 2;
    private static final int MAX_RANDOM_ENTITY_COUNT = 20;
    private static final int MIN_RANDOM_ENTITY_COUNT = 5;

    private List<Integer> heapConfiguration = new ArrayList<>();
    ;

    private final Random random = new Random();

    private int getIntBetween(final int min, final int max) {
        return random.nextInt(max - min) + min;
    }

    public NimGameCore(int heapCount, final int minEntity, final int maxEntity) {
        if (heapCount == 0) {
            heapCount = getIntBetween(MIN_RANDOM_HEAP_COUNT, MAX_RANDOM_HEAP_COUNT);
        }
        for (int i = 0; i < heapCount; i++) {
            heapConfiguration.add(getIntBetween(minEntity, maxEntity));
        }
    }

    public NimGameCore() {
        this(0, NimGameCore.MIN_RANDOM_ENTITY_COUNT, NimGameCore.MAX_RANDOM_ENTITY_COUNT);
    }

    public NimGameCore(List<Integer> heapConfiguration) throws GameSettingInvalidException {
        if (heapConfiguration.size() < MIN_HEAP_COUNT || heapConfiguration.size() > MAX_HEAP_COUNT) {
            throw new GameSettingInvalidException("Heap count does not satisfy heap count rules: " + MIN_HEAP_COUNT + " <= " + heapConfiguration.size() + " <= " + MAX_HEAP_COUNT);
        }
        for (int i : heapConfiguration) {
            if (i < MIN_ENTITY_COUNT || i > MAX_ENTITY_COUNT) {
                throw new GameSettingInvalidException("Number '" + i + "' does not satisfy entity count rules: " + MIN_ENTITY_COUNT + " <= " + i + " <= " + MAX_ENTITY_COUNT);
            }
        }
        this.heapConfiguration = new ArrayList<>(heapConfiguration); // Faster to working on a provisioned array.
    }

    @Override
    public void registerPlayer(NimPlayer player) throws PlayerAlreadyRegisteredException, PlayerListFullException {
        if (players.contains(player)) {
            throw new PlayerAlreadyRegisteredException("Player " + player.getName() + "already joined to the game");
        }
        if (players.size() > NimGameCore.MAX_PLAYER_COUNT) {
            throw new PlayerListFullException("No more room for other players. Player " + player.getName() + " was unable to join to the game. Maximum allowed number of players: " + NimGameCore.MIN_PLAYER_COUNT);
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
            throw new GameSetupIncompleteException("Not enough player joined to the game. Current player count: " + players.size() + " Minimum player count: " + NimGameCore.MIN_PLAYER_COUNT);
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
