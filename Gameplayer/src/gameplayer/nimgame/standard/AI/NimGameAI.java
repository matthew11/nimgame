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
public class NimGameAI{

    public static enum AI_Stategies {
        AI_WINNING_STRATEGY
    }

    private NimAIStrategy strategy;
    private AI_Stategies strategyInUse;
    private boolean isMisere;

    private void loadStrategy(AI_Stategies strategy, boolean isMisere) {
        switch (strategy) {
            case AI_WINNING_STRATEGY: {
                this.strategy = new AINimWinningStrategy(isMisere);
                break;
            }
        }
        this.isMisere = isMisere;
        this.strategyInUse = strategy;
    }

    public NimGameAI(boolean misereNim) {
        loadStrategy(AI_Stategies.AI_WINNING_STRATEGY, misereNim);
    }

    public AI_Stategies getStrategyInUse() {
        return strategyInUse;
    }

    public void setStrategyInUse(AI_Stategies strategyInUse) {
        loadStrategy(strategyInUse, this.isMisere);
    }

    public NimAISolution getNextStep(List<Integer> heapConfiguration) throws AIException {
        return strategy.getNextStep(heapConfiguration);
    }

}
