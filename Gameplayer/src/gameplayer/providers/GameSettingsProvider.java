/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameplayer.providers;

import gameplayer.gameengine.AbstractGameSettings;
import gameplayer.gameengine.exceptions.GameSettingsInvalidException;

/**
 *
 * @author Máté Pozsgay
 */
public interface GameSettingsProvider {
    public AbstractGameSettings getGameSettings() throws GameSettingsInvalidException;
}
