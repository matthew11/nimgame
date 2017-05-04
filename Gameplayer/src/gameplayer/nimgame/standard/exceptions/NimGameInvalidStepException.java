/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameplayer.nimgame.standard.exceptions;

import gameplayer.gameengine.exceptions.GameException;

/**
 *
 * @author Máté Pozsgay
 */
public class NimGameInvalidStepException extends GameException {

    public NimGameInvalidStepException(String message) {
        super(message);
    }

}
