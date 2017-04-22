/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szakdoga_prototype.gameengine;

import java.util.ArrayList;
import java.util.List;
import szakdoga_prototype.gameengine.exceptions.GameException;
import szakdoga_prototype.gameengine.exceptions.GameSetupIncompleteException;
import szakdoga_prototype.gameengine.exceptions.PlayerAlreadyRegisteredException;
import szakdoga_prototype.gameengine.exceptions.PlayerListFullException;
import szakdoga_prototype.gameengine.turnbased.exceptions.PlayerOrderException;
import szakdoga_prototype.nimgame.core.NimPlayer;
import szakdoga_prototype.nimgame.core.NimStepObject;

/**
 *
 * @author matthew
 */
public abstract class GameCore {

    protected final List<Player> players;
    protected int PROBA=0;

    public GameCore() {
        this.players = new ArrayList<>();
    }

    public void registerPlayer(NimPlayer player) throws PlayerAlreadyRegisteredException, PlayerListFullException {
        players.add(player);
    }


    public abstract boolean isInEndState();

    public abstract void nextStep(final StepObject step) throws PlayerOrderException, GameException;

    public abstract Player getWiningPlayer();

    public List<Player> getPlayers() {
        return players;
    }

    public abstract int getMaxPlayers();

    public abstract void startGame() throws GameSetupIncompleteException;

}
