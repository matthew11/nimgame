/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szakdoga_prototype.gameengine.events;

/**
 *
 * @author matthew
 */
public class GameEvent {

    private final Object origin;

    private final int eventType;

    public static final int EVENT_GAME_STARTED = 1;
    public static final int EVENT_GAME_STOPED = 2;
    public static final int EVENT_GAME_ENDED = 3;
    public static final int EVENT_PLAYER_REGISTERED = 4;

    /*public static enum GameEvents{
        EVENT_GAME_STARTED,
        EVENT_GAME_STOPED,
        EVENT_GAME_ENDED,
        EVENT_PLAYER_REGISTERED
    }*/
    public GameEvent(Object origin, int eventType) {
        this.origin = origin;
        this.eventType = eventType;
    }

    public int getEventType() {
        return eventType;
    }

}
