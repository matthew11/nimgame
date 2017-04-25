/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szakdoga_prototype.gameengine.eventmanager;

import szakdoga_prototype.gameengine.events.GameEvent;

/**
 *
 * @author matthew
 */
public interface GameEventListener {
    public void eventReceived(String channelName, GameEvent event);
}
