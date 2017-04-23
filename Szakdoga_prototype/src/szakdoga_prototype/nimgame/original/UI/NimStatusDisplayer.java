/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szakdoga_prototype.nimgame.original.UI;

import java.util.List;
import szakdoga_prototype.gameengine.Player;
import szakdoga_prototype.gameengine.StepObject;

/**
 *
 * @author matthew
 */
public interface NimStatusDisplayer {

    public void setCurrentPlayer(Player currentPlayer);

    public void setStepHistory(List<StepObject> stepHistory);
}
