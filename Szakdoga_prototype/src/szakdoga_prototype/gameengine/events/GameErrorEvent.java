/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szakdoga_prototype.gameengine.events;

/**
 *
 * @author matthew
 */
public class GameErrorEvent extends GameEvent{
    
    private final Exception cause;
    
    public GameErrorEvent(Object origin, Exception cause) {
        super(origin);
        this.cause = cause;
    }

    public Exception getCause() {
        return cause;
    }
    
    
    
}
