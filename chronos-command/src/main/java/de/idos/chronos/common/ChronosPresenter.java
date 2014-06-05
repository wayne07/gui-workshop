package de.idos.chronos.common;

import java.util.Timer;
import java.util.TimerTask;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class ChronosPresenter {

    private final ChronosModel timeModel;

    public ChronosPresenter(ChronosGui chronosGui, ChronosModel timeModel, GuiBuilder guiBuilder) {
        this.timeModel = timeModel;

        chronosGui.addTimeGui(guiBuilder.buildTimeGui(new CityModel("", DateTimeZone.forID("Europe/Athens"))));
        chronosGui.addTimeGui(guiBuilder.buildTimeGui(new CityModel("Frankfurt", DateTimeZone.forID("Europe/Berlin"))));
        chronosGui.addTimeGui(guiBuilder.buildTimeGui(new CityModel("Tokyo", DateTimeZone.forID("Asia/Tokyo"))));
        chronosGui.addTimeGui(guiBuilder.buildTimeGui(new CityModel("New York", DateTimeZone.forID("America/New_York"))));

        TimeChangeListener listener = new ModelToViewExchangeListener(timeModel, chronosGui);
        timeModel.addDataChangeListener(listener);
    }

    public void refreshPeriodic() {
        Timer timer = new Timer();

        final DateTime startDateTime = timeModel.getDateTime();

        TimerTask timerTask = new TimerTask() {

            DateTime nextDateTime = startDateTime;

            @Override
            public void run() {
                nextDateTime = nextDateTime.plusSeconds(1);
                timeModel.setDateTime(nextDateTime);
            }

        };
        long delayInMillis = 1000l;
        timer.schedule(timerTask, startDateTime.toDate(), delayInMillis);
    }

}
