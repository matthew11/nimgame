/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameplayer.nimgame.core.AI;

import java.util.List;
import gameplayer.nimgame.core.exceptions.AIException;

/**
 *
 * @author Máté Pozsgay
 */
public interface NimAI {

    public NimAISolution getNextStep(List<Integer> heapConfiguration) throws AIException;
}
