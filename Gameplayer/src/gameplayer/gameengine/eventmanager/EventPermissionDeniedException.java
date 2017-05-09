/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameplayer.gameengine.eventmanager;

/**
 *
 * @author Máté Pozsgay
 */
public class EventPermissionDeniedException extends Exception {

    EventPermissionDeniedException(String string) {
        super(string);
    }

}
