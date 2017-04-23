/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szakdoga_prototype.gameengine.turnbased;

import szakdoga_prototype.gameengine.GameCore;
import szakdoga_prototype.gameengine.Player;
import szakdoga_prototype.gameengine.turnbased.exceptions.PlayerOrderException;

/**
 *
 * @author matthew
 */
public abstract class TurnBasedGame extends GameCore {

    protected Player currentPlayer;

    public void nextTurn(final Player originatingPlayer) throws PlayerOrderException {
        validatePlayer(originatingPlayer);
        this.currentPlayer = getNextPlayer();
    }

    protected void validatePlayer(final Player player) throws PlayerOrderException {
        if (currentPlayer != player) {    // Since we store the object reference itself, I shouldn't use equals() here
            throw new PlayerOrderException("Invalid next step. Player " + player.getName() + "is not the next player");
        }

    }

    public Player getNextPlayer() {
        return getNextPlayer(currentPlayer);
    }

    public Player getNextPlayer(Player player) {
        int nextPlayerIndex = players.indexOf(player) + 1;
        if (nextPlayerIndex < players.size()) {
            return players.get(nextPlayerIndex);
        } else {
            return players.get(0);
        }
    }

    public Player getPreviousPlayer() {
        return getPreviousPlayer(currentPlayer);
    }

    public Player getPreviousPlayer(Player player) {
        int previousPlayerIndex = players.indexOf(player) - 1;
        if (previousPlayerIndex < 0) {
            return players.get(players.size() - 1);
        } else {
            return players.get(previousPlayerIndex);
        }
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

}
