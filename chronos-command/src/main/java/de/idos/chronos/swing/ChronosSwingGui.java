package de.idos.chronos.swing;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;

import org.joda.time.DateTime;

import de.idos.chronos.common.ChronosGui;
import de.idos.chronos.common.ChronosTimeGui;

public class ChronosSwingGui implements ChronosGui {

    private final JPanel panel = new JPanel();

    private final List<TimePanel> panels = new ArrayList<TimePanel>();

    public JComponent getComponent() {
        for (TimePanel singleGui : panels) {
            panel.add(singleGui.getComponent());
        }
        return panel;
    }

    public void setTime(DateTime time) {
        for (TimePanel panel : panels) {
            panel.setTime(time);
        }
    }

    public void addTimeGui(ChronosTimeGui timeGui) {
        panels.add((TimePanel)timeGui);
    }

}