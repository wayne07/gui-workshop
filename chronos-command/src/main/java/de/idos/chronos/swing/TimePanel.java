package de.idos.chronos.swing;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.joda.time.DateTime;

import de.idos.chronos.common.ChronosTimeGui;
import de.idos.chronos.common.format.ChronosFormatter;

public class TimePanel implements ChronosTimeGui {

    private final JLabel lblTime = new JLabel();
    private final JPanel panel = new JPanel();

    private final ChronosFormatter formatter;

    public TimePanel(String name, ChronosFormatter chronosFormatter) {
        this.formatter = chronosFormatter;
        createPanelWithTime(name);
    }

    public JPanel createPanelWithTime(String name) {
        JLabel label = new JLabel("Uhrzeit in " + name + ": ");
        if (name.isEmpty()) {
            label.setText("Uhrzeit: ");
        }

        panel.add(label);
        panel.add(lblTime);
        return panel;
    }

    public JComponent getComponent() {
        return panel;
    }

    public void setTime(DateTime time) {
        lblTime.setText(formatter.format(time));
    }

}