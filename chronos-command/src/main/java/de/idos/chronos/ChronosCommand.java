package de.idos.chronos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class ChronosCommand {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Ich brauche die millis seit 1970, z.B. " + new Date().getTime());
        }
        Long mylong = new Long(args[0]);
        Date date = new Date(mylong);
        int dateStyle = SimpleDateFormat.LONG;
        int timeStyle = SimpleDateFormat.LONG;
        //        Locale aLocale = new Builder().setLanguage("ell").build();
        Locale aLocale = new Locale("el-GR");

        DateFormat dateFormat = SimpleDateFormat.getDateTimeInstance(dateStyle, timeStyle, aLocale);


        System.out.println("Da hasch Dei Zeit: " + dateFormat.format(date));
    }
}
