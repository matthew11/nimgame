/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */

package gameplayer.gameengine.turnbased.exceptions;

/**
 *
 * @author Pozsgay Máté
 */
public class UndoBeforeFirstException extends TurnBasedGameException{

    public UndoBeforeFirstException() {
        super("Unable to revoke last step. No more steps left.");
    }

}
