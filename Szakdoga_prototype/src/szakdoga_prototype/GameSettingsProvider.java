/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szakdoga_prototype;

import szakdoga_prototype.gameengine.exceptions.GameSettingsInvalidException;

/**
 *
 * @author matthew
 */
public interface GameSettingsProvider {
    public AbstractGameSettings getGameSettings() throws GameSettingsInvalidException;
}
