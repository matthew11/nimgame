/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szakdoga_prototype.nimgame.core.AI;

import java.util.List;
import szakdoga_prototype.nimgame.core.AIException;

/**
 *
 * @author matthew
 */
public interface NimAI {
    public NimAISolution getNextStep(List<Integer> heapConfiguration) throws AIException;
}
