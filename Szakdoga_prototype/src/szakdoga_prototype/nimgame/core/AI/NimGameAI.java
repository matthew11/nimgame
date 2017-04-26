/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szakdoga_prototype.nimgame.core.AI;

import java.util.List;
import szakdoga_prototype.nimgame.core.exceptions.AIException;

/**
 *
 * @author matthew
 */
public class NimGameAI {

    private final AINimWinningStrategy strategy ;

    public NimGameAI(boolean misereNim) {
        strategy = new AINimWinningStrategy(misereNim);
    }

    public static enum AI_Stategies {
        AI_WINNING_STRATEGY
    }

    private AI_Stategies strategyInUse;

    public AI_Stategies getStrategyInUse() {
        return strategyInUse;
    }

    public void setStrategyInUse(AI_Stategies strategyInUse) {
        this.strategyInUse = strategyInUse;
    }

    public NimAISolution getNextStep(List<Integer> heapConfiguration) throws AIException {
        return strategy.getNextStep(heapConfiguration);
    }

}
