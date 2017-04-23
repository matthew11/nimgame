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
public class Player {

    private String name;

    public Player(String name) {
        this.name = name;
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
