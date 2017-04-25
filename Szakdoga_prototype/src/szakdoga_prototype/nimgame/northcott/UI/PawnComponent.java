/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szakdoga_prototype.nimgame.northcott.UI;

import java.awt.Color;
import javax.swing.JLabel;
import szakdoga_prototype.gameengine.Range;

/**
 *
 * @author matthew
 */
public class PawnComponent extends JLabel {

    protected final int playerID;
    protected int position;
    protected Range range = new Range(0, 1);

    public PawnComponent(int playerID, int position) {
        this.playerID = playerID;
        this.position = position;
        this.setText("PAWN " + Integer.toString(playerID));
        this.setForeground(new Color(255, 0, 0));
    }

    public int getPlayerID() {
        return playerID;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Range getRange() {
        return range;
    }

    public void setRange(Range range) {
        this.range = range;
    }

}
