package de.idos.chronos.swing;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import de.idos.chronos.common.ChronosGui;

public class ChronosSwingGui implements ChronosGui {

    private final JPanel panel = new JPanel();

    private final List<TimePanel> panels = new ArrayList<TimePanel>();

    public ChronosSwingGui() {
        panels.add(new TimePanel("", DateTimeZone.forID("Europe/Athens")));
        panels.add(new TimePanel("Frankfurt", DateTimeZone.forID("Europe/Berlin")));
        panels.add(new TimePanel("Tokyo", DateTimeZone.forID("Asia/Tokyo")));
        panels.add(new TimePanel("New York", DateTimeZone.forID("America/New_York")));
        panels.add(new TimePanel("New York", DateTimeZone.forID("America/New_York")));

        for (TimePanel singlePanel : panels) {
            panel.add(singlePanel.getComponent());
        }
    }

    public JComponent getComponent() {
        return panel;
    }

    /* (non-Javadoc)
     * @see de.idos.chronos.swing.ChronosGui#setTime(org.joda.time.DateTime)
     */
    public void setTime(DateTime time) {
        for (TimePanel panel : panels) {
            panel.setTime(time);
        }
    }

}