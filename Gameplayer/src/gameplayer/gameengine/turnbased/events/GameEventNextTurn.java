/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameplayer.gameengine.turnbased.events;

import gameplayer.gameengine.Player;

/**
 *
 * @author Máté Pozsgay
 */
public class GameEventNextTurn extends TurnbasedGameEvent {

    private final Player nextPlayer;

    public GameEventNextTurn(Object origin, Player nextPlayer) {
        super(origin, EVENT_GAME_NEXT_TURN);
        this.nextPlayer = nextPlayer;
    }

    public Player getNextPlayer() {
        return nextPlayer;
    }

}
