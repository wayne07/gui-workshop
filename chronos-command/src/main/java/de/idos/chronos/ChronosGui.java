package de.idos.chronos;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.joda.time.LocalTime;

class ChronosGui {

    private final JLabel separator1 = new JLabel(":");
    private final JLabel separator2 = new JLabel(":");
    private final JLabel hour = new JLabel();
    private final JLabel minute = new JLabel();
    private final JLabel second = new JLabel();

    private final JPanel panel = new JPanel();

    private final GuiUpdater update = new GuiUpdater(hour, minute, second);

    public ChronosGui() {
        createContent();
    }

    private JPanel createContent() {
        JLabel label = new JLabel("Uhrzeit: ");

        panel.add(label);
        panel.add(hour);
        panel.add(separator1);
        panel.add(minute);
        panel.add(separator2);
        panel.add(second);
        return panel;
    }

    public JComponent getComponent() {
        return panel;
    }

    public void setTime(LocalTime time) {
        update.updateTime(time);
    }

}