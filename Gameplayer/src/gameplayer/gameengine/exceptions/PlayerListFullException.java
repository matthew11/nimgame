/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameplayer.gameengine.exceptions;

/**
 *
 * @author Máté Pozsgay
 */
public class PlayerListFullException extends GameException{
    
    public PlayerListFullException(String message) {
        super(message);
    }
    
}
