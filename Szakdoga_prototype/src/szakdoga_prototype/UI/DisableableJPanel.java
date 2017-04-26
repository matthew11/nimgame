/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szakdoga_prototype.UI;

import java.awt.Component;
import java.awt.Container;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JPanel;

/**
 *
 * @author matthew
 */
public class DisableableJPanel extends JPanel implements RecursiveDisableContainer {

    private final Set<Component> disableIgnoreList = new HashSet<>();

    private void disableContainerRecursively(Container container) {
        for (Component component : container.getComponents()) {
            if (component.isEnabled()) {
                component.setEnabled(false);
            } else {
                disableIgnoreList.add(component);
            }
            if (component instanceof Container && (!(component instanceof RecursiveDisableContainer))) {
                disableContainerRecursively((Container) component);
            }
        }
    }

    private void enableContainerRecursively(Container container) {
        for (Component component : container.getComponents()) {
            if (!disableIgnoreList.contains(component)) {
                component.setEnabled(true);
            } else {
                disableIgnoreList.add(component);
            }
            if (component instanceof Container && (!(container instanceof RecursiveDisableContainer))) {
                disableContainerRecursively((Container) component);
            }
        }
    }

    @Override
    public void setEnabled(boolean enable) {
        if (isEnabled() == enable) {
            return;
        }
        if (enable) {
            enableContainerRecursively(this);
            disableIgnoreList.clear();
        } else {
            disableIgnoreList.clear();
            disableContainerRecursively(this);
        }
        super.setEnabled(enable);

    }

}
