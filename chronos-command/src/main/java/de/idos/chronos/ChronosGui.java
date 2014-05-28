package de.idos.chronos;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
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

    public JComponent getComponent() {
        return panel;
    }

    public void setTime(DateTime time) {
        for (TimePanel panel : panels) {
            panel.setTime(time);
        }
    }

}