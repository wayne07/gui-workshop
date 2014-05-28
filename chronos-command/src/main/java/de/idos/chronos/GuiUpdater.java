package de.idos.chronos;

import javax.swing.JLabel;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class GuiUpdater {

    private final JLabel hour;
    private final JLabel minute;
    private final JLabel second;
    private final DateTimeZone timeZone;

    public GuiUpdater(JLabel hour, JLabel minute, JLabel second, DateTimeZone timeZone) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.timeZone = timeZone;
    }

    public void updateTime(DateTime dateTime) {
        DateTime withZone = dateTime.withZone(timeZone);
        hour.setText(format(withZone.getHourOfDay()));
        minute.setText(format(withZone.getMinuteOfHour()));
        second.setText(format(withZone.getSecondOfMinute()));
    }

    private String format(int anyInteger) {
        if (anyInteger < 10) {
            return "0" + anyInteger;
        }
        return "" + anyInteger;
    }
}