/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szakdoga_prototype.gameengine;

import szakdoga_prototype.gameengine.exceptions.GameException;
import szakdoga_prototype.gameengine.turnbased.exceptions.PlayerOrderException;

/**
 *
 * @author matthew
 */
public interface PlayerControllerInterface {
    public AbstractGameSettings getGameSettings();
    public void nextStep(StepObject nextStep) throws PlayerOrderException, GameException;
}
