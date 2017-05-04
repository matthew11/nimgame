/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameplayer.nimgame.standard.events;

import gameplayer.nimgame.standard.NimStepObject;

/**
 *
 * @author Máté Pozsgay
 */
public class NimGameStepEvent extends NimGameEvent {

    private final NimStepObject stepObject;

    public NimGameStepEvent(Object origin, NimStepObject stepObject) {
        super(origin, NimGameEvent.EVENT_NEXT_STEP);
        this.stepObject = stepObject;
    }

    public NimStepObject getStepObject() {
        return stepObject;
    }

}
