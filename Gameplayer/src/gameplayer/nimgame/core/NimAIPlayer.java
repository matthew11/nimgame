/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameplayer.nimgame.core;

import gameplayer.nimgame.core.exceptions.AIException;
import gameplayer.gameengine.exceptions.GameException;
import gameplayer.nimgame.core.AI.NimAISolution;
import gameplayer.nimgame.core.AI.NimGameAI;

/**
 *
 * @author Máté Pozsgay
 */
public class NimAIPlayer extends NimPlayer {

    private final NimGameAI gameAI;

    public NimAIPlayer(int playerID, String name, NimPlayerController controller) {
        super(playerID, name, controller);
        gameAI = new NimGameAI(((NimGameSettings)controller.getGameSettings()).isMisereNimGame());
    }
    

    @Override
    public void notifyYourTurn() throws AIException, GameException {
        NimAISolution nextStep = gameAI.getNextStep(((NimPlayerController)controller).getHeapConfiguration());
        controller.nextStep(new NimStepObject(nextStep.getHeapID(), nextStep.getAlterValue(), this));
    }


}
