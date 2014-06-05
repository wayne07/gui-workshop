package de.idos.chronos.swing;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;

import org.joda.time.DateTime;

import de.idos.chronos.common.ChronosGui;
import de.idos.chronos.common.ChronosTimeGui;

public class ChronosSwingGui implements ChronosGui {

    private final JPanel panel = new JPanel();

    private final List<ChronosTimeGui> panels = new ArrayList<ChronosTimeGui>();

    public JComponent getComponent() {
        for (ChronosTimeGui singleGui : panels) {
            panel.add((Component)singleGui.getComponent());
        }
        return panel;
    }

    public void setTime(DateTime time) {
        for (ChronosTimeGui panel : panels) {
            panel.setTime(time);
        }
    }

    public void addTimeGui(ChronosTimeGui timeGui) {
        panels.add(timeGui);
    }

}