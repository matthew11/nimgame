/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameplayer.gameengine.events;

/**
 *
 * @author Máté Pozsgay
 */
public class GameEvent {

    private final Object origin;

    private final int eventType;
    public static final String EVENT_TYPE = Class.class.getCanonicalName();

    public static final int EVENT_GAME_STARTED = 1;
    public static final int EVENT_GAME_STOPED = 2;
    public static final int EVENT_GAME_ENDED = 3;
    public static final int EVENT_INTERNAL_ERROR = 66;
    public static final int EVENT_PLAYER_REGISTERED = 4;
    public static final int EVENT_NEXT_STEP = 5;
    public static final int EVENT_OTHER_EVENT = 99;

    /*public static enum GameEvents{
        EVENT_GAME_STARTED,
        EVENT_GAME_STOPED,
        EVENT_GAME_ENDED,
        EVENT_PLAYER_REGISTERED
    }*/
    public GameEvent(Object origin) {
        this(origin, EVENT_OTHER_EVENT);
        //EVENT_TYPE = this.getClass().getCanonicalName();
    }

    public GameEvent(Object origin, int eventType) {
        this.origin = origin;
        this.eventType = eventType;
    }

    public int getEventType() {
        return eventType;
    }

    public Object getOrigin() {
        return origin;
    }

}
