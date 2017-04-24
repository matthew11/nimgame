/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szakdoga_prototype.nimgame.core;

import szakdoga_prototype.gameengine.ControllerPlayerInterface;
import szakdoga_prototype.gameengine.Player;

/**
 *
 * @author matthew
 */
public abstract class NimPlayer extends Player  implements ControllerPlayerInterface {
    public NimPlayer(String name, NimPlayerController controller) {
        super(name, controller);
    }

    
}
