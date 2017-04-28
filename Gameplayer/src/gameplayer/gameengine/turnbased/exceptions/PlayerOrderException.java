/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameplayer.gameengine.turnbased.exceptions;

import gameplayer.gameengine.exceptions.GameException;

/**
 *
 * @author Máté Pozsgay
 */
public class PlayerOrderException extends GameException{

    public PlayerOrderException(final String message) {
        super(message);
    }
    
}
