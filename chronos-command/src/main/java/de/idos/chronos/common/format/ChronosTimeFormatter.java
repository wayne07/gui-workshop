package de.idos.chronos.common.format;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class ChronosTimeFormatter implements ChronosFormatter {

    private final DateTimeZone timeZone;
    private final DateTimeFormatter format;

    public ChronosTimeFormatter(DateTimeZone timeZone, String formatPattern) {
        this.timeZone = timeZone;
        format = DateTimeFormat.forPattern(formatPattern);
    }

    public String format(DateTime dateTime) {
        DateTime withZone = dateTime.withZone(timeZone);
        return format.print(withZone);
    }

}
