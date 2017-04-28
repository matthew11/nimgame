/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameplayer.nimgame.core.events;

import gameplayer.gameengine.events.GameEvent;

/**
 *
 * @author Máté Pozsgay
 */
public class NimGameEvent extends GameEvent {

    public static final int EVENT_NEXT_STEP = 100;
    public static final int EVENT_NEXT_TURN = 101;

    public NimGameEvent(Object origin, int eventType) {
        super(origin, eventType);
    }
    

}
