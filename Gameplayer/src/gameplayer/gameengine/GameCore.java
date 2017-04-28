/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameplayer.gameengine;

import gameplayer.gameengine.eventmanager.EventChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import gameplayer.gameengine.eventmanager.EventChannelInvalidException;
import gameplayer.gameengine.eventmanager.EventManager;
import gameplayer.gameengine.eventmanager.EventPermissionDeniedException;
import gameplayer.gameengine.eventmanager.EventRegistry;
import gameplayer.gameengine.events.GameEvent;
import gameplayer.gameengine.exceptions.GameException;
import gameplayer.gameengine.exceptions.GameSettingsInvalidException;
import gameplayer.gameengine.exceptions.GameSetupIncompleteException;
import gameplayer.gameengine.exceptions.PlayerAlreadyRegisteredException;
import gameplayer.gameengine.exceptions.PlayerListFullException;
import gameplayer.gameengine.turnbased.exceptions.PlayerOrderException;

/**
 *
 * @author Máté Pozsgay
 */
public abstract class GameCore {

    protected final List<Player> players;
    protected final List<StepObject> stepHistory = new ArrayList<>();
    protected final EventChannel eventChannel;

    public GameCore() throws EventChannelInvalidException {
        EventManager.createEventChannel(this, EventRegistry.EVENT_GAMEENGINE);
        this.eventChannel = EventManager.getEventChannel(EventRegistry.EVENT_GAMEENGINE);
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
        eventChannel.dispatchEvent(new GameEvent(this, GameEvent.EVENT_GAME_STARTED));
    }

    public void stopGame() {
        eventChannel.dispatchEvent(new GameEvent(this, GameEvent.EVENT_GAME_STOPED));
        try {
            EventManager.deleteEventChannel(this, EventRegistry.EVENT_GAMEENGINE);
        } catch (EventChannelInvalidException | EventPermissionDeniedException ex) {
            Logger.getLogger(GameCore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public EventChannel getEventChannel() {
        return eventChannel;
    }

}
