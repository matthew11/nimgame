/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szakdoga_prototype.gameengine.exceptions;

import szakdoga_prototype.gameengine.exceptions.GameException;

/**
 *
 * @author matthew
 */
public class PlayerListFull extends GameException{
    
    public PlayerListFull(String message) {
        super(message);
    }
    
}