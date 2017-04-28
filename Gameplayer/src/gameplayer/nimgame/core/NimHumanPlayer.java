/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameplayer.nimgame.core;

/**
 *
 * @author Máté Pozsgay
 */
public class NimHumanPlayer extends NimPlayer{

    public NimHumanPlayer(int playerID, String name, NimPlayerController controller) {
        super(playerID, name, controller);
    }
    
    @Override
    public void notifyYourTurn() {
        
    }

    
}
