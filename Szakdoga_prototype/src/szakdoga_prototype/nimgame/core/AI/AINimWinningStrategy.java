/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szakdoga_prototype.nimgame.core.AI;

import szakdoga_prototype.nimgame.core.AI.NimAI;
import java.util.List;
import szakdoga_prototype.nimgame.core.AI.NimAISolution;
import szakdoga_prototype.nimgame.core.AIException;

/**
 *
 * @author matthew
 */
public class AINimWinningStrategy implements NimAI {

    private List<Integer> heapConfiguration;

    private int getNimSum() {
        int s = 0;
        for (Integer i : heapConfiguration) {
            s ^= i;
        }

        return s;
    }

    private int getFirstNonemptyHeapID() {
        int testID = 0;
        while (testID < heapConfiguration.size() && heapConfiguration.get(testID) <= 0) {  // Look for the first non-empty heap
            testID++;
        }
        if (testID >= heapConfiguration.size()) {
            return -1;
        }
        return testID;
    }

    private NimAISolution getBestMove() throws AIException {
        int testID, testMove = 1, originaValue;
        boolean solutionFound = false;
        testID = getFirstNonemptyHeapID();
        if (testID < 0) {
            throw new AIException("Attempt to execute on an empty gamespace!");
        }
        testID--;
        while ((!solutionFound) && (testID + 1 < heapConfiguration.size())) {
            testID++;
            if (heapConfiguration.get(testID) > 0) {
                originaValue = heapConfiguration.get(testID);
                heapConfiguration.set(testID, heapConfiguration.get(testID) - 1);
                while (heapConfiguration.get(testID) >= 0 && (getNimSum() != 0)) {
                    heapConfiguration.set(testID, heapConfiguration.get(testID) - 1);
                    System.out.println("Testing: " + heapConfiguration + "=" + getNimSum());
                }
                if (heapConfiguration.get(testID) >= 0) {
                    testMove = originaValue - heapConfiguration.get(testID);
                    System.out.println("Solution found.");
                    solutionFound = true;
                }
                heapConfiguration.set(testID, originaValue);
            }
        }

        if (!solutionFound) { // Curerntly there is no winning move :(
            System.out.println("Faking solution.");
            testID = getFirstNonemptyHeapID();
            testMove = 1;
        }

        return new NimAISolution(testID, testMove);
    }

    @Override
    public NimAISolution getNextStep(List<Integer> heapConfiguration) throws AIException {
        this.heapConfiguration = heapConfiguration;
        System.out.println("Current NIM sum: " + getNimSum());

        return getBestMove();
    }

}
