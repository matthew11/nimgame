/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameplayer.nimgame.northcott.UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import gameplayer.utils.Range;

/**
 *
 * @author Máté Pozsgay
 */
public class PawnComponent extends JPanel {

    protected final int playerID;
    protected int position;
    protected Range range = new Range(0, 1);
    private BufferedImage graphic = null;

    public PawnComponent(int playerID, int position) {
        try {
            this.graphic = ImageIO.read(getClass().getResource("/gameplayer/nimgame/northcott/UI/resources/" + (playerID == 0 ? "pawn_white.png" : "pawn_black.png")));
        } catch (IOException | IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this.getParent(), "Error: Failed to load internal pawn resource. Using text instead");
            this.add(new JLabel("ERROR - " + playerID));
        }
        this.playerID = playerID;
        this.position = position;
        this.setForeground(new Color(255, 0, 0));

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(this.getParent().getBackground());
        if (graphic != null) {
            g.drawImage(graphic, 0, 0, getWidth(), getHeight(), this);
        }
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
