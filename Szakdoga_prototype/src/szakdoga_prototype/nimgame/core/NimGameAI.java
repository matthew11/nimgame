/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szakdoga_prototype.nimgame.core;

import java.util.List;
import szakdoga_prototype.gameengine.StepObject;

/**
 *
 * @author matthew
 */
public class NimGameAI {

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

    public StepObject getNextStep(List heapConfiguration) {
        return null;
    }

}
