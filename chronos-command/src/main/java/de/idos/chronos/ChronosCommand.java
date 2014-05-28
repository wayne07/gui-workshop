package de.idos.chronos;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class ChronosCommand {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Ich brauche die millis seit 1970, z.B. " + new Date().getTime());
        }

        DateTime dateTime = new DateTime(Long.parseLong(args[0]), DateTimeZone.UTC);

        DateTime athensTime = dateTime.withZone(DateTimeZone.forID("Europe/Athens"));

        System.out.println(athensTime.toString());

        Long mylong = new Long(args[0]);
        Date date = new Date(mylong);

        SimpleDateFormat isoFormat = new SimpleDateFormat("HH:mm:ss");
        isoFormat.setTimeZone(TimeZone.getTimeZone("Europe/Athens"));

        System.out.println("Da hasch Dei Zeit: " + isoFormat.format(date));
    }

}
