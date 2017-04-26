/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szakdoga_prototype.gameengine.exceptions;

/**
 *
 * @author matthew
 */
public class GameSettingsInvalidException extends GameException{
    
    public GameSettingsInvalidException(String message) {
        super("Game configuration invalid: " + message);
    }
    
}
