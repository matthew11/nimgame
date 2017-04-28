/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameplayer.nimgame.core;

import gameplayer.gameengine.ControllerPlayerInterface;
import gameplayer.gameengine.Player;

/**
 *
 * @author Máté Pozsgay
 */
public abstract class NimPlayer extends Player  implements ControllerPlayerInterface {
    public NimPlayer(int playerID, String name, NimPlayerController controller) {
        super(playerID, name, controller);
    }

    
}
