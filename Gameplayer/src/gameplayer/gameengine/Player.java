/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameplayer.gameengine;

/**
 *
 * @author Máté Pozsgay
 */
public abstract class Player{

    protected final String name;
    protected final int playerID;
    protected PlayerControllerInterface controller;

    public Player(int playerID, String name, PlayerControllerInterface controller) {
        this.playerID = playerID;
        this.name = name;
        this.controller = controller;
    }

    public String getName() {
        return name;
    }

    public void stop() {
    }

    @Override
    public String toString() {
        return name;
    }

    public int getPlayerID() {
        return playerID;
    }

}
