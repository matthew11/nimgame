/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szakdoga_prototype.nimgame.core;

import szakdoga_prototype.gameengine.exceptions.GameException;
import szakdoga_prototype.nimgame.core.AI.NimAISolution;
import szakdoga_prototype.nimgame.core.AI.NimGameAI;

/**
 *
 * @author matthew
 */
public class NimAIPlayer extends NimPlayer {

    private final NimGameAI gameAI;

    public NimAIPlayer(String name, NimPlayerController controller) {
        super(name, controller);
        gameAI = new NimGameAI(((NimGameSettings)controller.getGameSettings()).isMisereNimGame());
    }
    

    @Override
    public void notifyYourTurn() throws AIException, GameException {
        NimAISolution nextStep = gameAI.getNextStep(((NimPlayerController)controller).getHeapConfiguration());
        controller.nextStep(new NimStepObject(nextStep.getHeapID(), nextStep.getAlterValue(), this));
    }


}
