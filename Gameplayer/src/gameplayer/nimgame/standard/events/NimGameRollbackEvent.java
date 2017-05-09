/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package gameplayer.nimgame.standard.events;

import gameplayer.nimgame.standard.NimStepObject;

/**
 *
 * @author Pozsgay Máté
 */
public class NimGameRollbackEvent extends NimGameEvent {

    private final NimStepObject undoStep;

    public NimGameRollbackEvent(Object sender, NimStepObject undoStep) {
        super(sender, EVENT_GAME_UNDO_TURN);
        this.undoStep = undoStep;
    }

    public NimStepObject getUndoStep() {
        return undoStep;
    }

}
