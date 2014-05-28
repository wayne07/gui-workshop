package de.idos.chronos;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

class ChronosGui {

    private final JPanel panel = new JPanel();

    private final List<TimePanel> panels = new ArrayList<TimePanel>();

    public ChronosGui() {
        panels.add(new TimePanel("", DateTimeZone.forID("Europe/Athens")));
        panels.add(new TimePanel("Frankfurt", DateTimeZone.forID("Europe/Berlin")));
        panels.add(new TimePanel("Tokyo", DateTimeZone.forID("Asia/Tokyo")));
        panels.add(new TimePanel("New York", DateTimeZone.forID("America/New_York")));

        for (TimePanel singlePanel : panels) {
            panel.add(singlePanel.getComponent());
        }
    }

    static class TimePanel {

        private final JLabel separator1 = new JLabel(":");
        private final JLabel separator2 = new JLabel(":");
        private final JLabel hour = new JLabel();
        private final JLabel minute = new JLabel();
        private final JLabel second = new JLabel();

        private final JPanel panel = new JPanel();
        private final GuiUpdater updater;

        public TimePanel(String name, DateTimeZone timeZone) {
            createPanelWithTime(name);
            updater = new GuiUpdater(hour, minute, second, timeZone);
        }

        public JPanel createPanelWithTime(String name) {
            JLabel label = new JLabel("Uhrzeit in " + name + ": ");
            if (name.isEmpty()) {
                label.setText("Uhrzeit: ");
            }

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

        public void setTime(DateTime time) {
            updater.updateTime(time);
        }

    }


    public JComponent getComponent() {
        return panel;
    }

    public void setTime(DateTime time) {
        for (TimePanel panel : panels) {
            panel.setTime(time);
        }
    }

}