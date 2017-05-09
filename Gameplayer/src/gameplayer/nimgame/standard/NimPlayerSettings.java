/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameplayer.nimgame.standard;

/**
 *
 * @author Máté Pozsgay
 */
public class NimPlayerSettings {

    private final int playerID;
    private final String playerName;
    private final boolean isAI;
    private final boolean starter;

    public NimPlayerSettings(int playerID, String playerName, boolean isAI, boolean starter) {
        this.playerID = playerID;
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

    int getPlayerID() {
        return playerID;
    }
    
    
}
