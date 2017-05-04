/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameplayer.gameengine;

import gameplayer.nimgame.standard.NimPlayer;

/**
 *
 * @author Máté Pozsgay
 */
public abstract class StepObject implements Cloneable{

    protected Player originatingPlayer;

    public StepObject(NimPlayer originatingPlayer) {
        this.originatingPlayer = originatingPlayer;
    }

    public Player getOriginatingPlayer() {
        return originatingPlayer;
    }

    @Override
    public String toString() {
        return "Step object of player '" + originatingPlayer.getName() + "'";
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    
}
