/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szakdoga_prototype.nimgame.core;

import szakdoga_prototype.gameengine.StepObject;

/**
 *
 * @author matthew
 */
public class NimStepObject extends StepObject {

    protected int heapID;
    protected int amount;

    public NimStepObject(int heapID, int amount, NimPlayer originatingPlayer) {
        super(originatingPlayer);
        this.heapID = heapID;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public int getHeapID() {
        return heapID;
    }

    @Override
    public String toString() {
        return originatingPlayer.getName() + ": [" + heapID + "]-" + amount;
    }

}
