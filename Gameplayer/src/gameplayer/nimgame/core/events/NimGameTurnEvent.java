/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameplayer.nimgame.core.events;

import gameplayer.gameengine.Player;

/**
 *
 * @author Máté Pozsgay
 */
public class NimGameTurnEvent extends NimGameEvent {

    private final Player nextPlayer;

    public NimGameTurnEvent(Object origin, Player nextPlayer) {
        super(origin, NimGameEvent.EVENT_NEXT_TURN);
        this.nextPlayer = nextPlayer;
    }

    public Player getNextPlayer() {
        return nextPlayer;
    }

}
