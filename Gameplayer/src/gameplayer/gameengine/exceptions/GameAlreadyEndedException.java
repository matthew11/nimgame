/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */

package gameplayer.gameengine.exceptions;

/**
 *
 * @author Pozsgay Máté
 */
public class GameAlreadyEndedException extends GameException{

    public GameAlreadyEndedException() {
        super("Game already ended.");
    }

}
