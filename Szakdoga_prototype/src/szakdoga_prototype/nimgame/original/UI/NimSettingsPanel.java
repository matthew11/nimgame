/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szakdoga_prototype.nimgame.original.UI;

import java.util.ArrayList;
import java.util.List;
import javax.swing.SpinnerNumberModel;
import szakdoga_prototype.AbstractGameSettings;
import szakdoga_prototype.GameSettingsProvider;
import szakdoga_prototype.gameengine.Player;
import szakdoga_prototype.gameengine.exceptions.GameSettingsInvalidException;
import szakdoga_prototype.nimgame.core.NimAIPlayer;
import szakdoga_prototype.nimgame.core.NimGameCore;
import szakdoga_prototype.nimgame.core.NimGameSettings;
import szakdoga_prototype.nimgame.core.NimHumanPlayer;
import szakdoga_prototype.nimgame.core.NimPlayer;

/**
 *
 * @author matthew
 */
public class NimSettingsPanel extends javax.swing.JPanel implements GameSettingsProvider {

    private final NimGameSettings gameSettings = new NimGameSettings();

    private final SpinnerNumberModel minHeapCountModel = new SpinnerNumberModel(2, NimGameCore.MIN_RANDOM_HEAP_COUNT, NimGameCore.MAX_RANDOM_HEAP_COUNT, 1);
    private final SpinnerNumberModel maxHeapCountModel = new SpinnerNumberModel(2, NimGameCore.MIN_RANDOM_HEAP_COUNT, NimGameCore.MAX_RANDOM_HEAP_COUNT, 1);
    private final SpinnerNumberModel minEntityCountModel = new SpinnerNumberModel(10, NimGameCore.MIN_RANDOM_ENTITY_COUNT, NimGameCore.MAX_RANDOM_ENTITY_COUNT, 1);
    private final SpinnerNumberModel maxEntityCountModel = new SpinnerNumberModel(10, NimGameCore.MIN_RANDOM_ENTITY_COUNT, NimGameCore.MAX_RANDOM_ENTITY_COUNT, 1);

    /**
     * Creates new form NimGameSettingsPanel
     */
    public NimSettingsPanel() {
        initComponents();
        configTypeRandomActionPerformed(null);
        playerEntryPanel1.setStarter(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        starterGroup = new javax.swing.ButtonGroup();
        gameSettingsPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        heapConfigurationTextField = new javax.swing.JTextField();
        heapConfigurationTextField.setVisible(false);
        configTypeRandom = new javax.swing.JRadioButton();
        configTypeCustom = new javax.swing.JRadioButton();
        configTypeControlledRandom = new javax.swing.JRadioButton();
        controlledRandomPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        rndMinHeapCountSpinner = new javax.swing.JSpinner();
        rndMaxHeapCountSpinner = new javax.swing.JSpinner();
        rndMinEntityCountSpinner = new javax.swing.JSpinner();
        rndMaxEntityCountSpinner = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        playerHeaderPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        playerEntryPanel1 = new szakdoga_prototype.nimgame.original.UI.PlayerEntryPanel(starterGroup);
        playerEntryPanel2 = new szakdoga_prototype.nimgame.original.UI.PlayerEntryPanel(starterGroup);

        jLabel1.setText("Heap configuration:");

        heapConfigurationTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        heapConfigurationTextField.setText("5 8 14 7 9 3");

        buttonGroup1.add(configTypeRandom);
        configTypeRandom.setSelected(true);
        configTypeRandom.setText("Random configuration");
        configTypeRandom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configTypeRandomActionPerformed(evt);
            }
        });

        buttonGroup1.add(configTypeCustom);
        configTypeCustom.setText("Custom configuration");
        configTypeCustom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configTypeCustomActionPerformed(evt);
            }
        });

        buttonGroup1.add(configTypeControlledRandom);
        configTypeControlledRandom.setText("Controlled random configuration");
        configTypeControlledRandom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configTypeControlledRandomActionPerformed(evt);
            }
        });

        controlledRandomPanel.setVisible(false);

        jLabel7.setText("Heaps");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Min");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Max");

        jLabel9.setText("Elements");

        rndMinHeapCountSpinner.setModel(minHeapCountModel);
        rndMinHeapCountSpinner.setToolTipText("");
        rndMinHeapCountSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rndMinHeapCountSpinnerStateChanged(evt);
            }
        });

        rndMaxHeapCountSpinner.setModel(maxHeapCountModel);

        rndMinEntityCountSpinner.setModel(minEntityCountModel);

        rndMaxEntityCountSpinner.setModel(maxEntityCountModel);

        javax.swing.GroupLayout controlledRandomPanelLayout = new javax.swing.GroupLayout(controlledRandomPanel);
        controlledRandomPanel.setLayout(controlledRandomPanelLayout);
        controlledRandomPanelLayout.setHorizontalGroup(
            controlledRandomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlledRandomPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(controlledRandomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(controlledRandomPanelLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(38, 38, 38)
                        .addGroup(controlledRandomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rndMinHeapCountSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(controlledRandomPanelLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(rndMinEntityCountSpinner)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(controlledRandomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rndMaxHeapCountSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rndMaxEntityCountSpinner))
                .addContainerGap())
        );
        controlledRandomPanelLayout.setVerticalGroup(
            controlledRandomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlledRandomPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(controlledRandomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6))
                .addGap(7, 7, 7)
                .addGroup(controlledRandomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rndMinHeapCountSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rndMaxHeapCountSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(controlledRandomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rndMinEntityCountSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(rndMaxEntityCountSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("Players:");

        jLabel3.setText("Starter");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Player Name");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("AI");

        javax.swing.GroupLayout playerHeaderPanelLayout = new javax.swing.GroupLayout(playerHeaderPanel);
        playerHeaderPanel.setLayout(playerHeaderPanelLayout);
        playerHeaderPanelLayout.setHorizontalGroup(
            playerHeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playerHeaderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap())
        );
        playerHeaderPanelLayout.setVerticalGroup(
            playerHeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playerHeaderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(playerHeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(playerHeaderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(playerHeaderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout gameSettingsPanelLayout = new javax.swing.GroupLayout(gameSettingsPanel);
        gameSettingsPanel.setLayout(gameSettingsPanelLayout);
        gameSettingsPanelLayout.setHorizontalGroup(
            gameSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gameSettingsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gameSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(heapConfigurationTextField)
                    .addComponent(controlledRandomPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(playerEntryPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(gameSettingsPanelLayout.createSequentialGroup()
                        .addGroup(gameSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(configTypeRandom)
                            .addComponent(configTypeCustom)
                            .addComponent(configTypeControlledRandom))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(playerEntryPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        gameSettingsPanelLayout.setVerticalGroup(
            gameSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gameSettingsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(configTypeRandom)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(configTypeControlledRandom)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(configTypeCustom)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(controlledRandomPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(heapConfigurationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(playerEntryPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(playerEntryPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gameSettingsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(gameSettingsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void disableSettingsPanels() {
        heapConfigurationTextField.setVisible(false);
        controlledRandomPanel.setVisible(false);
        this.revalidate();
    }

    private void configTypeRandomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configTypeRandomActionPerformed
        disableSettingsPanels();
        gameSettings.setConfigType(NimGameSettings.ConfigurationType.CONFIG_TYPE_RANDOM);
    }//GEN-LAST:event_configTypeRandomActionPerformed

    private void configTypeControlledRandomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configTypeControlledRandomActionPerformed
        disableSettingsPanels();
        controlledRandomPanel.setVisible(true);
        this.revalidate();
        gameSettings.setConfigType(NimGameSettings.ConfigurationType.CONFIG_TYPE_CONTROLLED_RANDOM);
    }//GEN-LAST:event_configTypeControlledRandomActionPerformed

    private void configTypeCustomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configTypeCustomActionPerformed
        disableSettingsPanels();
        heapConfigurationTextField.setVisible(true);
        this.revalidate();
        gameSettings.setConfigType(NimGameSettings.ConfigurationType.CONFIG_TYPE_CUSTOM);
    }//GEN-LAST:event_configTypeCustomActionPerformed

    private void rndMinHeapCountSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rndMinHeapCountSpinnerStateChanged

    }//GEN-LAST:event_rndMinHeapCountSpinnerStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton configTypeControlledRandom;
    private javax.swing.JRadioButton configTypeCustom;
    private javax.swing.JRadioButton configTypeRandom;
    private javax.swing.JPanel controlledRandomPanel;
    private javax.swing.JPanel gameSettingsPanel;
    private javax.swing.JTextField heapConfigurationTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private szakdoga_prototype.nimgame.original.UI.PlayerEntryPanel playerEntryPanel1;
    private szakdoga_prototype.nimgame.original.UI.PlayerEntryPanel playerEntryPanel2;
    private javax.swing.JPanel playerHeaderPanel;
    private javax.swing.JSpinner rndMaxEntityCountSpinner;
    private javax.swing.JSpinner rndMaxHeapCountSpinner;
    private javax.swing.JSpinner rndMinEntityCountSpinner;
    private javax.swing.JSpinner rndMinHeapCountSpinner;
    private javax.swing.ButtonGroup starterGroup;
    // End of variables declaration//GEN-END:variables

    private List<Integer> parseHeapConfiguration(String configurationText) {
        List<Integer> configuration = new ArrayList<>();
        for (String i : configurationText.split(" ")) {
            if (i.equals("")) {
                continue;
            }
            configuration.add(Integer.parseInt(i));
        }
        return configuration;
    }

    private NimPlayer getPlayerFromPlayerPanel(PlayerEntryPanel playerPanel) {
        if (playerPanel.isAI()) {
            return new NimAIPlayer(playerPanel.getPlayerName());
        } else {
            return new NimHumanPlayer(playerPanel.getPlayerName());
        }
    }

    @Override
    public AbstractGameSettings getGameSettings() throws GameSettingsInvalidException {
        List<Integer> heapConfiguration;
        if (gameSettings.getConfigType() == NimGameSettings.ConfigurationType.CONFIG_TYPE_CUSTOM) {
            try {
                heapConfiguration = parseHeapConfiguration(heapConfigurationTextField.getText());
                gameSettings.setHeapConfiguration(heapConfiguration);
            } catch (NumberFormatException ex) {
                throw new GameSettingsInvalidException("Cannot parse heap configuration. Please make sure you specfiy a space separated list of integer numbers");
            }
        }
        List<Player> players = new ArrayList<>();
        players.add(getPlayerFromPlayerPanel(playerEntryPanel1));
        players.add(getPlayerFromPlayerPanel(playerEntryPanel2));
        gameSettings.setPlayers(players);
        gameSettings.setMinHeapCount((int) minHeapCountModel.getValue());
        gameSettings.setMaxHeapCount((int) maxHeapCountModel.getValue());
        gameSettings.setMinEntityCount((int) minEntityCountModel.getValue());
        gameSettings.setMaxEntityCount((int) maxEntityCountModel.getValue());
        if (playerEntryPanel1.isStarter()) {
            gameSettings.setStartingPlayer(gameSettings.getPlayers().get(0));
        } else {
            gameSettings.setStartingPlayer(gameSettings.getPlayers().get(1));
        }
        return gameSettings;
    }
}
