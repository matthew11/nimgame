/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szakdoga_prototype.gameengine;

import java.util.ArrayList;
import java.util.List;
import szakdoga_prototype.gameengine.events.GameEvent;
import szakdoga_prototype.gameengine.events.GameEventListener;

/**
 *
 * @author matthew
 */
public class EventHandler {

    List<GameEventListener> listeners = new ArrayList<>();

   
    public void dispacthEvent(GameEvent event){
        for(GameEventListener listener: listeners){
            listener.eventReceived(event);
        }
    }
    
    public void subscribeForEvent(GameEventListener eventListener){
        listeners.add(eventListener);
    }
}
