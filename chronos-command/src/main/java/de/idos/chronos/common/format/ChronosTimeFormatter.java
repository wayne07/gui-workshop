package de.idos.chronos.common.format;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class ChronosTimeFormatter implements ChronosFormatter {

    private final DateTimeZone timeZone;

    public ChronosTimeFormatter(DateTimeZone timeZone) {
        this.timeZone = timeZone;
    }

    public String format(DateTime dateTime) {
        DateTime withZone = dateTime.withZone(timeZone);
        DateTimeFormatter format = DateTimeFormat.forPattern("HH:mm:ss");
        return format.print(withZone);
    }

}
