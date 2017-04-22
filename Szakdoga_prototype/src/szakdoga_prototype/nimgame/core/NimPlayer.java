/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szakdoga_prototype.nimgame.core;

import szakdoga_prototype.gameengine.Player;
import szakdoga_prototype.gameengine.exceptions.GameException;
import szakdoga_prototype.gameengine.turnbased.exceptions.PlayerOrderException;

/**
 *
 * @author matthew
 */
public class NimPlayer extends Player{

    private NimGameCore controller;

    public NimPlayer(String name, NimGameCore controller) {
        super(name);
        this.controller = controller;
    }


    public void doNextStep(int heapID, int amount) throws PlayerOrderException, GameException{
        controller.nextStep(new NimStepObject(heapID, amount, this));
    }

    public void setController(NimGameCore controller) {
        this.controller = controller;
    }
    
}
