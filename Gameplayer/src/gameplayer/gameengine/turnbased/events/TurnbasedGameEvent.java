/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package gameplayer.gameengine.turnbased.events;

import gameplayer.gameengine.events.GameEvent;

/**
 *
 * @author Pozsgay Máté
 */
public class TurnbasedGameEvent extends GameEvent {

    public static final int EVENT_GAME_NEXT_TURN = 100;
    public static final int EVENT_GAME_UNDO_TURN = 101;

    public TurnbasedGameEvent(Object origin, int eventType) {
        super(origin, eventType);
    }

}
