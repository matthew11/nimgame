/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameplayer.nimgame.core;

import java.util.List;
import gameplayer.gameengine.PlayerControllerInterface;

/**
 *
 * @author Máté Pozsgay
 */
public interface NimPlayerController extends PlayerControllerInterface{

    public List<Integer> getHeapConfiguration();
}
