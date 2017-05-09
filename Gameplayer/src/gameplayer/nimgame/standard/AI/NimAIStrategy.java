/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameplayer.nimgame.standard.AI;

import java.util.List;
import gameplayer.nimgame.standard.exceptions.AIException;

/**
 *
 * @author Máté Pozsgay
 */
public interface NimAIStrategy {

    public NimAISolution getNextStep(List<Integer> heapConfiguration) throws AIException;
}
