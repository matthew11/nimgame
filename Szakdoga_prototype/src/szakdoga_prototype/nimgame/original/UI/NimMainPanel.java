/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szakdoga_prototype.nimgame.original.UI;

import java.awt.Component;
import javax.swing.JOptionPane;
import szakdoga_prototype.gameengine.eventmanager.EventChannelInvalidException;
import szakdoga_prototype.gameengine.eventmanager.EventManager;
import szakdoga_prototype.gameengine.eventmanager.EventRegistry;
import szakdoga_prototype.providers.GameSettingsProvider;
import szakdoga_prototype.gameengine.events.GameEvent;
import szakdoga_prototype.gameengine.eventmanager.GameEventListener;
import szakdoga_prototype.gameengine.exceptions.GameException;
import szakdoga_prototype.nimgame.core.NimGameCore;
import szakdoga_prototype.nimgame.core.events.NimGameEvent;
import szakdoga_prototype.nimgame.core.NimPlayer;
import szakdoga_prototype.nimgame.core.NimStepObject;
import szakdoga_prototype.providers.GameEntityProvider;

/**
 *
 * @author matthew
 */
public class NimMainPanel extends javax.swing.JPanel implements GameEventListener, GameEntityProvider {

    private final NimGameCore nimGame;
    private final NimSettingsPanel settingsPanel = new NimSettingsPanel();
    private final NimStatusPanel statusPanel = new NimStatusPanel();

    /**
     * Creates new form mainPanel
     *
     * @param nimGame
     */
    public NimMainPanel(final NimGameCore nimGame) throws EventChannelInvalidException {
        this.nimGame = nimGame;
        EventManager.getEventChannel(EventRegistry.EVENT_GAMEENGINE).subscribeForEvent(this);
        initComponents();
    }

    public void startGame() {
        for (int i = 0; i < nimGame.getHeapCount(); i++) {
            gameSpace.add(new HeapPanel(this, i, nimGame.getHeapValue(i)));
        }
        statusPanel.setCurrentPlayer(nimGame.getCurrentPlayer());
        gameSpace.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPane = new javax.swing.JScrollPane();
        gameSpace = new javax.swing.JPanel();

        gameSpace.setLayout(new java.awt.GridBagLayout());
        scrollPane.setViewportView(gameSpace);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 863, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void updatePanels() {
        for (Component component : gameSpace.getComponents()) {
            if (component instanceof HeapPanel) {
                HeapPanel panel = (HeapPanel) component;
                panel.setPanelValue(nimGame.getHeapValue(panel.getPanelID()));
            }
        }
        this.statusPanel.setCurrentPlayer(nimGame.getCurrentPlayer());
        this.statusPanel.setStepHistory(nimGame.getStepHistory());

    }

    void heapChanged(int panelID, int value) {
        try {
            nimGame.nextStep(new NimStepObject(panelID, value, (NimPlayer) nimGame.getCurrentPlayer()));
        } catch (GameException ex) {
            JOptionPane.showMessageDialog(this, "The requested opration cannot be processed: " + ex.getMessage());
        }
    }

    @Override
    public void eventReceived(String channelName, GameEvent event) {
        switch (event.getEventType()) {
            case GameEvent.EVENT_GAME_STARTED: {
                startGame();
                break;
            }
            case GameEvent.EVENT_GAME_STOPED: {
                gameSpace.removeAll();
                gameSpace.revalidate();
                break;

            }
            case GameEvent.EVENT_GAME_ENDED: {
                updatePanels();
                gameSpace.removeAll();
                gameSpace.revalidate();
                gameSpace.repaint();
                JOptionPane.showMessageDialog(this, "The game is normally ended. Player '" + nimGame.getWiningPlayer() + "' won the game.");
                break;
            }
            case NimGameEvent.EVENT_NEXT_TURN: {
                updatePanels();
                break;
            }
            default: {
                JOptionPane.showMessageDialog(this, "Error: Unhandled event. Type: " + event.getEventType());
            }

        }
    }

    @Override
    public Component getMainUIComponent() {
        return this;
    }

    @Override
    public Component getSettingsUIComponent() {
        return settingsPanel;
    }

    @Override
    public Component getStatusUIComponent() {
        return statusPanel;
    }

    @Override
    public GameSettingsProvider getSettingsProvider() {
        return settingsPanel;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel gameSpace;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables
}
