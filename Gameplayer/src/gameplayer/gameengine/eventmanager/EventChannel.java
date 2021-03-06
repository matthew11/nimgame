/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameplayer.gameengine.eventmanager;

import java.util.ArrayList;
import java.util.List;
import gameplayer.gameengine.events.GameEvent;

/**
 *
 * @author Máté Pozsgay
 */
public class EventChannel {

    private final List<GameEventListener> listeners = new ArrayList<>();
    private final String channelName;

    public EventChannel(String channelName) {
        this.channelName = channelName;
    }

    public void dispatchEvent(GameEvent event) {
        listeners.forEach((listener) -> {
            listener.eventReceived(this.channelName, event);
        });
    }

    public void subscribeForChannel(GameEventListener eventListener) {
        listeners.add(eventListener);
    }
    
    public void unsubscribeFromChannel(GameEventListener eventListener){
        listeners.remove(eventListener);
    }
}
