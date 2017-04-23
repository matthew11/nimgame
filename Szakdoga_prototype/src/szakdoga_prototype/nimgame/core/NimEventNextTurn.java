/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szakdoga_prototype.nimgame.core;

import szakdoga_prototype.gameengine.Player;

/**
 *
 * @author matthew
 */
public class NimEventNextTurn extends NimGameEvent {

    private final Player nextPlayer;

    public NimEventNextTurn(Object origin, int eventType, Player nextPlayer) {
        super(origin, eventType);
        this.nextPlayer = nextPlayer;
    }

    public Player getNextPlayer() {
        return nextPlayer;
    }

}
