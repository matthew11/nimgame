/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameplayer.gameengine;

import gameplayer.gameengine.exceptions.GameException;

/**
 *
 * @author Máté Pozsgay
 */
public interface ControllerPlayerInterface {
    public void notifyYourTurn() throws GameException;
}
