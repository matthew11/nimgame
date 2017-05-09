/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameplayer.nimgame.standard.events;

import gameplayer.gameengine.turnbased.events.TurnbasedGameEvent;

/**
 *
 * @author Máté Pozsgay
 */
public class NimGameEvent extends TurnbasedGameEvent {

    public NimGameEvent(Object origin, int eventType) {
        super(origin, eventType);
    }
    

}
