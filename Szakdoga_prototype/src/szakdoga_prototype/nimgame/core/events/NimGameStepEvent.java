/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szakdoga_prototype.nimgame.core.events;

import szakdoga_prototype.nimgame.core.NimStepObject;
import szakdoga_prototype.nimgame.core.events.NimGameEvent;

/**
 *
 * @author matthew
 */
public class NimGameStepEvent extends NimGameEvent {

    private final NimStepObject stepObject;

    public NimGameStepEvent(Object origin, NimStepObject stepObject, int eventType) {
        super(origin, eventType);
        this.stepObject = stepObject;
    }

    public NimStepObject getStepObject() {
        return stepObject;
    }

}
