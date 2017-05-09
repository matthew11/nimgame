/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameplayer.nimgame.standard;

import gameplayer.gameengine.Player;

/**
 *
 * @author Máté Pozsgay
 */
public abstract class NimPlayer extends Player {

    public NimPlayer(int playerID, String name, NimPlayerController controller) {
        super(playerID, name, controller);
    }

}
