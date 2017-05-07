/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameplayer.gameengine.events;

/**
 *
 * @author Máté Pozsgay
 */
public class GameErrorEvent extends GameEvent{
    
    private final Exception cause;
    
    public GameErrorEvent(Object origin, Exception cause) {
        super(origin, EVENT_ERROR_EVENT);
        this.cause = cause;
    }

    public Exception getCause() {
        return cause;
    }
    
    
    
}
