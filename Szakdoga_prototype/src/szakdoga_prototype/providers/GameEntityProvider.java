/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szakdoga_prototype.providers;

import szakdoga_prototype.GameSettingsProvider;

/**
 *
 * @author matthew
 */
public interface GameEntityProvider extends GameUIProvider{
    public GameSettingsProvider getSettingsProvider();
}