/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameplayer.nimgame.standard.events;

import gameplayer.gameengine.Player;
import gameplayer.gameengine.turnbased.events.TurnbasedGameEvent;

/**
 *
 * @author Máté Pozsgay
 */
public class NimGameTurnEvent extends NimGameEvent {

    private final Player nextPlayer;

    public NimGameTurnEvent(Object origin, Player nextPlayer) {
        super(origin, TurnbasedGameEvent.EVENT_GAME_NEXT_TURN);
        this.nextPlayer = nextPlayer;
    }

    public Player getNextPlayer() {
        return nextPlayer;
    }

}
