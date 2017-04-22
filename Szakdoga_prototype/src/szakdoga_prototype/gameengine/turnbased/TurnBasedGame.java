/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szakdoga_prototype.gameengine.turnbased;

import szakdoga_prototype.gameengine.GameCore;
import szakdoga_prototype.gameengine.Player;
import szakdoga_prototype.gameengine.StepObject;
import szakdoga_prototype.gameengine.exceptions.GameException;
import szakdoga_prototype.gameengine.turnbased.exceptions.PlayerOrderException;

/**
 *
 * @author matthew
 */
public abstract class TurnBasedGame extends GameCore {

    protected Player currentPlayer;

    public abstract void nextStep(final StepObject step) throws PlayerOrderException, GameException;

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
        int nextPlayerIndex = players.indexOf(currentPlayer) + 1;
        if (nextPlayerIndex < players.size()) {
            return players.get(nextPlayerIndex);
        } else {
            return players.get(0);
        }
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

}
