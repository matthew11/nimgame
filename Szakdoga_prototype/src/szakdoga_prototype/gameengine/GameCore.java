/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szakdoga_prototype.gameengine;

import java.util.ArrayList;
import java.util.List;
import szakdoga_prototype.AbstractGameSettings;
import szakdoga_prototype.gameengine.events.GameEvent;
import szakdoga_prototype.gameengine.exceptions.GameException;
import szakdoga_prototype.gameengine.exceptions.GameSettingsInvalidException;
import szakdoga_prototype.gameengine.exceptions.GameSetupIncompleteException;
import szakdoga_prototype.gameengine.exceptions.PlayerAlreadyRegisteredException;
import szakdoga_prototype.gameengine.exceptions.PlayerListFullException;
import szakdoga_prototype.gameengine.turnbased.exceptions.PlayerOrderException;

/**
 *
 * @author matthew
 */
public abstract class GameCore {

    protected final List<Player> players;
    protected final List<StepObject> stepHistory = new ArrayList<>();
    protected final EventCenter eventCenter = new EventCenter();

    public GameCore() {
        this.players = new ArrayList<>();
    }

    public void registerPlayer(Player player) throws PlayerAlreadyRegisteredException, PlayerListFullException {
        for (Player i : players) {
            if (i.getName().equals(player.getName())) {
                throw new PlayerAlreadyRegisteredException("Name '" + player.getName() + "' is already taken");
            }
        }
        players.add(player);
    }

    public abstract void loadGameSettings(AbstractGameSettings gameSettings) throws GameSettingsInvalidException, PlayerAlreadyRegisteredException, PlayerListFullException;

    public abstract boolean isInEndState();

    public abstract void nextStep(final StepObject step) throws PlayerOrderException, GameException;

    public abstract void undoStep();

    public List<StepObject> getStepHistory() {
        return new ArrayList<>(stepHistory);
    }

    public abstract Player getWiningPlayer();

    public List<Player> getPlayers() {
        return players;
    }

    public abstract int getMaxPlayers();

    public void startGame() throws GameSetupIncompleteException {
        eventCenter.dispatchEvent(new GameEvent(this, GameEvent.EVENT_GAME_STARTED));
    }

    public void stopGame() {
        eventCenter.dispatchEvent(new GameEvent(this, GameEvent.EVENT_GAME_STOPED));
    }

    public EventCenter getEventCenter() {
        return eventCenter;
    }

}
