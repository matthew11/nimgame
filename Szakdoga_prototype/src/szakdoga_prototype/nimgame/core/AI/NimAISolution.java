/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szakdoga_prototype.nimgame.core.AI;

/**
 *
 * @author matthew
 */
public class NimAISolution {

    private final int heapID;
    private final int alterValue;

    public NimAISolution(int heapID, int alterValue) {
        this.heapID = heapID;
        this.alterValue = alterValue;
    }

    public int getAlterValue() {
        return alterValue;
    }

    public int getHeapID() {
        return heapID;
    }

    
}
