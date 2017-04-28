/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameplayer.nimgame.northcott.UI;

import gameplayer.gameengine.AbstractGameSettings;
import gameplayer.providers.GameSettingsProvider;
import gameplayer.gameengine.exceptions.GameSettingsInvalidException;
import gameplayer.nimgame.core.NimGameSettings;

/**
 *
 * @author Máté Pozsgay
 */
public class NorthcottSettingsPanel extends javax.swing.JPanel implements GameSettingsProvider{

    private final NorthcottMainPanel mainPanel;
    /**
     * Creates new form NorthcottSettingsPanel
     */
    public NorthcottSettingsPanel(NorthcottMainPanel mainPanel) {
        initComponents();
        this.mainPanel = mainPanel;
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

        starterPlayerGroup = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        columnCountSpinner = new javax.swing.JSpinner();
        rowCountSpinner = new javax.swing.JSpinner();
        playerEntryPanel1 = new gameplayer.nimgame.original.UI.PlayerEntryPanel(0, starterPlayerGroup);
        playerEntryPanel2 = new gameplayer.nimgame.original.UI.PlayerEntryPanel(1, starterPlayerGroup);
        misereGameCheckBox = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();

        jLabel2.setText("Dimensions:");

        jLabel1.setText("Horizontal:");

        jLabel3.setText("Vertical:");

        columnCountSpinner.setModel(new javax.swing.SpinnerNumberModel(8, 3, 15, 1));
        columnCountSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                columnCountSpinnerStateChanged(evt);
            }
        });

        rowCountSpinner.setModel(new javax.swing.SpinnerNumberModel(8, 3, 15, 1));
        rowCountSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rowCountSpinnerStateChanged(evt);
            }
        });

        misereGameCheckBox.setText("Misère NIM Game");

        jLabel4.setText("Players:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(misereGameCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(playerEntryPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(columnCountSpinner, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rowCountSpinner, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(playerEntryPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rowCountSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(columnCountSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)))
                .addComponent(misereGameCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(playerEntryPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(playerEntryPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void columnCountSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_columnCountSpinnerStateChanged
        mainPanel.columnChanged((int) columnCountSpinner.getValue());
    }//GEN-LAST:event_columnCountSpinnerStateChanged

    private void rowCountSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rowCountSpinnerStateChanged
        mainPanel.rowChanged((int) rowCountSpinner.getValue());
    }//GEN-LAST:event_rowCountSpinnerStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner columnCountSpinner;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JCheckBox misereGameCheckBox;
    private gameplayer.nimgame.original.UI.PlayerEntryPanel playerEntryPanel1;
    private gameplayer.nimgame.original.UI.PlayerEntryPanel playerEntryPanel2;
    private javax.swing.JSpinner rowCountSpinner;
    private javax.swing.ButtonGroup starterPlayerGroup;
    // End of variables declaration//GEN-END:variables

    @Override
    public AbstractGameSettings getGameSettings() throws GameSettingsInvalidException {
        NimGameSettings gameSettings = new NimGameSettings();
        gameSettings.setConfigType(NimGameSettings.ConfigurationType.CONFIG_TYPE_CUSTOM);
        gameSettings.setHeapConfiguration(mainPanel.getHeapConfiguration());
        gameSettings.setMisereNimGame(misereGameCheckBox.isSelected());
        gameSettings.addPlayer(playerEntryPanel1.getPlayerSettings());
        gameSettings.addPlayer(playerEntryPanel2.getPlayerSettings());
        return gameSettings;
    }
}
