/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameplayer;

import gameplayer.providers.GameSettingsProvider;
import java.awt.Component;
import java.awt.Container;
import gameplayer.gameengine.GameCore;
import gameplayer.gameengine.exceptions.GameSettingsInvalidException;
import gameplayer.gameengine.exceptions.GameSetupIncompleteException;
import gameplayer.gameengine.exceptions.PlayerAlreadyRegisteredException;
import gameplayer.gameengine.exceptions.PlayerListFullException;
import gameplayer.providers.GameEntityProvider;

/**
 *
 * @author Máté Pozsgay
 */
public class GameController {

    private final GameCore game;
    private final GameSettingsProvider settingsProvider;
    private final GameEntityProvider entityProvider;

    public GameController(GameCore game, GameEntityProvider entityProvider) {
        this.game = game;
        this.settingsProvider = entityProvider.getSettingsProvider();
        this.entityProvider = entityProvider;
    }

    private void removeSelf(Component component) {
        component.getParent().remove(component);
    }

    public void destroyGame() {
        game.stopGame();
        removeSelf(entityProvider.getMainUIComponent());
        removeSelf(entityProvider.getSettingsUIComponent());
        removeSelf(entityProvider.getStatusUIComponent());
    }

    public void loadUIElements(Container targetMainPanel, Container targetSettingsPanel, Container targetStatusPanel) {
        targetMainPanel.removeAll();
        targetSettingsPanel.removeAll();
        targetStatusPanel.removeAll();
        targetMainPanel.add(entityProvider.getMainUIComponent());
        targetSettingsPanel.add(entityProvider.getSettingsUIComponent());
        targetStatusPanel.add(entityProvider.getStatusUIComponent());
        targetSettingsPanel.validate();
        targetMainPanel.validate();
        targetStatusPanel.validate();
    }

    public GameCore getGame() {
        return game;
    }

    public GameSettingsProvider getSettingsProvider() {
        return settingsProvider;
    }

    public void startGame() throws GameSettingsInvalidException, PlayerAlreadyRegisteredException, PlayerListFullException, GameSetupIncompleteException {
        this.game.loadGameSettings(settingsProvider.getGameSettings());
        this.game.startGame();
    }

    void undoLastStep() {
        game.undoStep();
    }

}
