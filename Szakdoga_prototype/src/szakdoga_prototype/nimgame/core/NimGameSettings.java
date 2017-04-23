/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szakdoga_prototype.nimgame.core;

import java.util.List;
import szakdoga_prototype.AbstractGameSettings;
import szakdoga_prototype.gameengine.Player;

/**
 *
 * @author matthew
 */
public class NimGameSettings extends AbstractGameSettings {

    public static enum ConfigurationType {
        CONFIG_TYPE_RANDOM, CONFIG_TYPE_CONTROLLED_RANDOM, CONFIG_TYPE_CUSTOM
    }

    private List<Integer> heapConfiguration;
    private ConfigurationType configType;
    private List<Player> players;
    private Player startingPlayer;
    private int minHeapCount, maxHeapCount, minEntityCount, maxEntityCount;

    public List<Integer> getHeapConfiguration() {
        return heapConfiguration;
    }

    public void setHeapConfiguration(List<Integer> heapConfiguration) {
        this.heapConfiguration = heapConfiguration;
    }

    public ConfigurationType getConfigType() {
        return configType;
    }

    public void setConfigType(ConfigurationType configType) {
        this.configType = configType;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Player getStartingPlayer() {
        return startingPlayer;
    }

    public void setStartingPlayer(Player startingPlayer) {
        this.startingPlayer = startingPlayer;
    }

    public int getMinHeapCount() {
        return minHeapCount;
    }

    public void setMinHeapCount(int minHeapCount) {
        this.minHeapCount = minHeapCount;
    }

    public int getMaxHeapCount() {
        return maxHeapCount;
    }

    public void setMaxHeapCount(int maxHeapCount) {
        this.maxHeapCount = maxHeapCount;
    }

    public int getMinEntityCount() {
        return minEntityCount;
    }

    public void setMinEntityCount(int minEntityCount) {
        this.minEntityCount = minEntityCount;
    }

    public int getMaxEntityCount() {
        return maxEntityCount;
    }

    public void setMaxEntityCount(int maxEntityCount) {
        this.maxEntityCount = maxEntityCount;
    }

}