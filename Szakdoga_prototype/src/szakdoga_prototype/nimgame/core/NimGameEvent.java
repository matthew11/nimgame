/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szakdoga_prototype.nimgame.core;

import szakdoga_prototype.gameengine.events.GameEvent;

/**
 *
 * @author matthew
 */
public class NimGameEvent extends GameEvent {

    public static final int EVENT_NEXT_TURN = 100;
    private String message;

    public NimGameEvent(Object origin, int eventType, String message) {
        super(origin, eventType);
    }
    
    public NimGameEvent(Object origin, int eventType) {
        this(origin, eventType, "");
    }

}
