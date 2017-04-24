/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szakdoga_prototype.nimgame.core.AI;

import java.util.Arrays;
import java.util.List;
import szakdoga_prototype.nimgame.core.exceptions.AIException;

/**
 *
 * @author matthew
 */
public class AINimWinningStrategy implements NimAI {

    private final DecisionMaker decisionMaker;

    public AINimWinningStrategy(boolean misereNim) {
        if(misereNim){
            decisionMaker = new NimMisereDecisionMaker();
        }else{
            decisionMaker = new NimStandardDecisionMaker();
        }
    }

    private interface DecisionMaker {

        public boolean acceptSolution(int nimSum);
    }

    private class NimStandardDecisionMaker implements DecisionMaker {

        @Override
        public boolean acceptSolution(int nimSum) {
            return nimSum == 0;
        }

    }

    private class NimMisereDecisionMaker implements DecisionMaker {

        @Override
        public boolean acceptSolution(int nimSum) {
            return nimSum == 1;
        }

    }

    private int getNimSum(int[] heapConfiguration) {
        int s = 0;
        for (Integer i : heapConfiguration) {
            s ^= i;
        }

        return s;
    }

    private int getFirstNonemptyHeapID(int[] heapConfiguration) {
        int testID = 0;
        while (testID < heapConfiguration.length && heapConfiguration[testID] <= 0) {  // Look for the first non-empty heap
            testID++;
        }
        if (testID >= heapConfiguration.length) {
            return -1;
        }
        return testID;
    }

    private NimAISolution getBestMove(int[] heapConfiguration) throws AIException {
        int testID, testMove = 1, originaValue;
        boolean solutionFound = false;
        testID = getFirstNonemptyHeapID(heapConfiguration);
        if (testID < 0) {
            throw new AIException("Attempt to execute on an empty gamespace!");
        }
        testID--;
        while ((!solutionFound) && (testID + 1 < heapConfiguration.length)) {
            testID++;
            if (heapConfiguration[testID] > 0) {
                originaValue = heapConfiguration[testID];
                heapConfiguration[testID]--;
                while (heapConfiguration[testID] >= 0 && ! decisionMaker.acceptSolution(getNimSum(heapConfiguration))) {
                    heapConfiguration[testID]--;
                    System.out.println("Testing: " + Arrays.toString(heapConfiguration) + "=" + getNimSum(heapConfiguration));
                }
                if (heapConfiguration[testID] >= 0) {
                    testMove = originaValue - heapConfiguration[testID];
                    System.out.println("Solution found.");
                    solutionFound = true;
                }
                heapConfiguration[testID] = originaValue;
            }
        }

        if (!solutionFound) { // Curerntly there is no winning move :(
            System.out.println("Faking solution.");
            testID = getFirstNonemptyHeapID(heapConfiguration);
            testMove = 1;
        }

        return new NimAISolution(testID, testMove);
    }

    @Override
    public NimAISolution getNextStep(List<Integer> heapConfiguration) throws AIException {
        return getBestMove(heapConfiguration.stream().mapToInt(i -> i).toArray());
    }

}
