/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szakdoga_prototype.nimgame.core;

/**
 *
 * @author matthew
 */
public class NimPlayerSettings {

    private final String playerName;
    private final boolean isAI;
    private final boolean starter;

    public NimPlayerSettings(String playerName, boolean isAI, boolean starter) {
        this.playerName = playerName;
        this.isAI = isAI;
        this.starter = starter;
    }

    public String getPlayerName() {
        return playerName;
    }

    public boolean isIsAI() {
        return isAI;
    }

    public boolean isStarter() {
        return starter;
    }
    
    
}
