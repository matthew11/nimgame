/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szakdoga_prototype.gameengine;

/**
 *
 * @author matthew
 */
public abstract class Player implements ControllerPlayerInterface {

    protected String name;
    protected PlayerControllerInterface controller;

    public Player(String name, PlayerControllerInterface controller) {
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

}
