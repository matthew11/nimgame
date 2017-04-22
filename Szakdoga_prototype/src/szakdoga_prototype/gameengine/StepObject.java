/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szakdoga_prototype.gameengine;

import szakdoga_prototype.nimgame.core.NimPlayer;

/**
 *
 * @author matthew
 */
public class StepObject {
    private NimPlayer originatingPlayer;

    public StepObject(NimPlayer originatingPlayer) {
        this.originatingPlayer = originatingPlayer;
    }

    public NimPlayer getOriginatingPlayer() {
        return originatingPlayer;
    }
    
    
    
}
