/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szakdoga_prototype.nimgame.core;

import szakdoga_prototype.gameengine.PlayerControllerInterface;

/**
 *
 * @author matthew
 */
public class NimAIPlayer extends NimPlayer {

    private final NimGameAI gameAI = new NimGameAI();

    public NimAIPlayer(String name, NimPlayerController controller) {
        super(name, controller);
    }
    


    @Override
    public void notifyYourTurn() {
        gameAI.getNextStep(controller.getHeapConfiguration());
    }


}
