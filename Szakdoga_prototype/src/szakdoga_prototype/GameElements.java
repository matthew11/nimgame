/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szakdoga_prototype;

import javax.swing.JPanel;
import szakdoga_prototype.gameengine.GameCore;

/**
 *
 * @author matthew
 */
public class GameElements {

    private final JPanel gameSettingsPanel;
    private final JPanel gameMainPanel;
    private final GameCore game;
    private final GameSettingsProvider settingsProvider;

    public GameElements(GameCore game, GameSettingsProvider settingsProvider, JPanel gameSettingsPanel, JPanel gameMainPanel) {
        this.game = game;
        this.gameSettingsPanel = gameSettingsPanel;
        this.gameMainPanel = gameMainPanel;
        this.settingsProvider = settingsProvider;
    }

    public void destroyGame() {
        game.stopGame();
        gameSettingsPanel.getParent().remove(gameSettingsPanel);
        gameMainPanel.getParent().remove(gameMainPanel);
    }

    public GameCore getGame() {
        return game;
    }

    public GameSettingsProvider getSettingsProvider() {
        return settingsProvider;
    }

}
