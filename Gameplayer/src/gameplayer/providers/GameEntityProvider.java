/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameplayer.providers;

/**
 *
 * @author Máté Pozsgay
 */
public interface GameEntityProvider extends GameUIProvider{
    public GameSettingsProvider getSettingsProvider();
}
