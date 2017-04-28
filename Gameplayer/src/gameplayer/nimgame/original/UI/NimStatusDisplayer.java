/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameplayer.nimgame.original.UI;

import java.util.List;
import gameplayer.gameengine.Player;
import gameplayer.gameengine.StepObject;

/**
 *
 * @author Máté Pozsgay
 */
public interface NimStatusDisplayer {

    public void setCurrentPlayer(Player currentPlayer);

    public void setStepHistory(List<StepObject> stepHistory);
}
