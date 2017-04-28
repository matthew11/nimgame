/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameplayer.gameengine.eventmanager;

import gameplayer.gameengine.events.GameEvent;

/**
 *
 * @author Máté Pozsgay
 */
public interface GameEventListener {
    public void eventReceived(String channelName, GameEvent event);
}
