package de.idos.chronos;

import javax.swing.JLabel;

import org.joda.time.LocalTime;

public class GuiUpdater {

    private final JLabel hour;
    private final JLabel minute;
    private final JLabel second;

    public GuiUpdater(JLabel hour, JLabel minute, JLabel second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;

    }

    public void updateTime(LocalTime startTime) {
        hour.setText(format(startTime.getHourOfDay()));
        minute.setText(format(startTime.getMinuteOfHour()));
        second.setText(format(startTime.getSecondOfMinute()));
    }

    private String format(int anyInteger) {
        if (anyInteger < 10) {
            return "0" + anyInteger;
        }
        return "" + anyInteger;
    }
}