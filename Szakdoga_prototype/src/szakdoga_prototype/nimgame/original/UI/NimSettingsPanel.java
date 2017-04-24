/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szakdoga_prototype.nimgame.original.UI;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.SpinnerNumberModel;
import szakdoga_prototype.gameengine.AbstractGameSettings;
import szakdoga_prototype.providers.GameSettingsProvider;
import szakdoga_prototype.gameengine.exceptions.GameSettingsInvalidException;
import szakdoga_prototype.nimgame.core.NimGameCore;
import szakdoga_prototype.nimgame.core.NimGameSettings;
import szakdoga_prototype.nimgame.core.NimPlayerSettings;

/**
 *
 * @author matthew
 */
public class NimSettingsPanel extends JPanel implements GameSettingsProvider{

    private final NimGameSettings gameSettings = new NimGameSettings();

    private final SpinnerNumberModel minHeapCountModel = new SpinnerNumberModel(2, NimGameCore.MIN_HEAP_COUNT, NimGameCore.MAX_HEAP_COUNT, 1);
    private final SpinnerNumberModel maxHeapCountModel = new SpinnerNumberModel(6, NimGameCore.MIN_HEAP_COUNT, NimGameCore.MAX_HEAP_COUNT, 1);
    private final SpinnerNumberModel minEntityCountModel = new SpinnerNumberModel(3, NimGameCore.MIN_ENTITY_COUNT, NimGameCore.MAX_ENTITY_COUNT, 1);
    private final SpinnerNumberModel maxEntityCountModel = new SpinnerNumberModel(9, NimGameCore.MIN_ENTITY_COUNT, NimGameCore.MAX_ENTITY_COUNT, 1);

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
        jLabel1 = new javax.swing.JLabel();
        configTypeRandom = new javax.swing.JRadioButton();
        configTypeControlledRandom = new javax.swing.JRadioButton();
        configTypeCustom = new javax.swing.JRadioButton();
        controlledRandomPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        rndMinHeapCountSpinner = new javax.swing.JSpinner();
        rndMaxHeapCountSpinner = new javax.swing.JSpinner();
        rndMinEntityCountSpinner = new javax.swing.JSpinner();
        rndMaxEntityCountSpinner = new javax.swing.JSpinner();
        heapConfigurationTextField = new javax.swing.JTextField();
        heapConfigurationTextField.setVisible(false);
        misereNimGameCheckbox = new javax.swing.JCheckBox();
        playerPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        playerEntryPanel1 = new szakdoga_prototype.nimgame.original.UI.PlayerEntryPanel(starterGroup);
        playerEntryPanel2 = new szakdoga_prototype.nimgame.original.UI.PlayerEntryPanel(starterGroup);
        playerHeaderPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jLabel1.setText("Heap configuration:");

        buttonGroup1.add(configTypeRandom);
        configTypeRandom.setSelected(true);
        configTypeRandom.setText("Full random");
        configTypeRandom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configTypeRandomActionPerformed(evt);
            }
        });

        buttonGroup1.add(configTypeControlledRandom);
        configTypeControlledRandom.setText("Controlled random");
        configTypeControlledRandom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configTypeControlledRandomActionPerformed(evt);
            }
        });

        buttonGroup1.add(configTypeCustom);
        configTypeCustom.setText("Custom");
        configTypeCustom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configTypeCustomActionPerformed(evt);
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
        rndMinHeapCountSpinner.setMaximumSize(new java.awt.Dimension(38, 26));
        rndMinHeapCountSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rndMinHeapCountSpinnerStateChanged(evt);
            }
        });

        rndMaxHeapCountSpinner.setModel(maxHeapCountModel);

        rndMinEntityCountSpinner.setModel(minEntityCountModel);
        rndMinEntityCountSpinner.setMaximumSize(new java.awt.Dimension(38, 26));

        rndMaxEntityCountSpinner.setModel(maxEntityCountModel);

        javax.swing.GroupLayout controlledRandomPanelLayout = new javax.swing.GroupLayout(controlledRandomPanel);
        controlledRandomPanel.setLayout(controlledRandomPanelLayout);
        controlledRandomPanelLayout.setHorizontalGroup(
            controlledRandomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlledRandomPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(controlledRandomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(controlledRandomPanelLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(rndMinEntityCountSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(controlledRandomPanelLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(38, 38, 38)
                        .addGroup(controlledRandomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(controlledRandomPanelLayout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26))
                            .addComponent(rndMinHeapCountSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(controlledRandomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rndMaxHeapCountSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
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

        heapConfigurationTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        heapConfigurationTextField.setText("5 8 14 7 9 3");

        misereNimGameCheckbox.setSelected(true);
        misereNimGameCheckbox.setText("Misère NIM Game");

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
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
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

        javax.swing.GroupLayout playerPanelLayout = new javax.swing.GroupLayout(playerPanel);
        playerPanel.setLayout(playerPanelLayout);
        playerPanelLayout.setHorizontalGroup(
            playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(playerPanelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(playerHeaderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(playerEntryPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(playerEntryPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        playerPanelLayout.setVerticalGroup(
            playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playerPanelLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(playerHeaderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(playerEntryPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(playerEntryPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(heapConfigurationTextField)
                    .addComponent(misereNimGameCheckbox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(controlledRandomPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(configTypeRandom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(configTypeControlledRandom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(configTypeCustom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(playerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
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
                .addComponent(misereNimGameCheckbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(playerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rndMinHeapCountSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rndMinHeapCountSpinnerStateChanged

    }//GEN-LAST:event_rndMinHeapCountSpinnerStateChanged

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

    private void configTypeRandomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configTypeRandomActionPerformed
        disableSettingsPanels();
        gameSettings.setConfigType(NimGameSettings.ConfigurationType.CONFIG_TYPE_RANDOM);
    }//GEN-LAST:event_configTypeRandomActionPerformed

    private void disableSettingsPanels() {
        heapConfigurationTextField.setVisible(false);
        controlledRandomPanel.setVisible(false);
        this.revalidate();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton configTypeControlledRandom;
    private javax.swing.JRadioButton configTypeCustom;
    private javax.swing.JRadioButton configTypeRandom;
    private javax.swing.JPanel controlledRandomPanel;
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
    private javax.swing.JCheckBox misereNimGameCheckbox;
    private szakdoga_prototype.nimgame.original.UI.PlayerEntryPanel playerEntryPanel1;
    private szakdoga_prototype.nimgame.original.UI.PlayerEntryPanel playerEntryPanel2;
    private javax.swing.JPanel playerHeaderPanel;
    private javax.swing.JPanel playerPanel;
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

    private NimPlayerSettings getPlayerFromPlayerPanel(PlayerEntryPanel playerPanel) {
        return new NimPlayerSettings(playerPanel.getPlayerName(), playerPanel.isAI(), playerPanel.isStarter());
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
        List<NimPlayerSettings> players = new ArrayList<>();
        players.add(getPlayerFromPlayerPanel(playerEntryPanel1));
        players.add(getPlayerFromPlayerPanel(playerEntryPanel2));
        gameSettings.setPlayers(players);
        gameSettings.setMinHeapCount((int) minHeapCountModel.getValue());
        gameSettings.setMaxHeapCount((int) maxHeapCountModel.getValue());
        gameSettings.setMinEntityCount((int) minEntityCountModel.getValue());
        gameSettings.setMaxEntityCount((int) maxEntityCountModel.getValue());
        gameSettings.setMisereNimGame(misereNimGameCheckbox.isSelected());
        return gameSettings;
    }

}
