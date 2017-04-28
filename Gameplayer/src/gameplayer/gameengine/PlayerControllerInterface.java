/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameplayer.gameengine;

import gameplayer.gameengine.exceptions.GameException;
import gameplayer.gameengine.turnbased.exceptions.PlayerOrderException;

/**
 *
 * @author Máté Pozsgay
 */
public interface PlayerControllerInterface {
    public AbstractGameSettings getGameSettings();
    public void nextStep(StepObject nextStep) throws PlayerOrderException, GameException;
}
