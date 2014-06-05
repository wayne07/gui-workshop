package de.idos.chronos.common;

import java.util.Date;
import java.util.Timer;

import org.joda.time.DateTimeZone;

import de.idos.chronos.common.format.ChronosTimeFormatter;

public class ChronosPresenter {

    private final long delayInMillis = 1000l;
    private final String patternHourMinuteSecond = "HH:mm:ss";
    private final String patternHourMinute = "HH:mm";

    private final ChronosModel timeModel;

    public ChronosPresenter(ChronosGui chronosGui, ChronosModel timeModel, GuiBuilder guiBuilder) {
        this.timeModel = timeModel;

        chronosGui.addTimeGui(guiBuilder.buildTimeGui(new CityModel("", DateTimeZone.forID("Europe/Athens")), new ChronosTimeFormatter(DateTimeZone.forID("Europe/Athens"), patternHourMinute)));
        chronosGui.addTimeGui(guiBuilder.buildTimeGui(new CityModel("Frankfurt", DateTimeZone.forID("Europe/Berlin")), new ChronosTimeFormatter(DateTimeZone.forID("Europe/Athens"), patternHourMinuteSecond)));
        chronosGui.addTimeGui(guiBuilder.buildTimeGui(new CityModel("Tokyo", DateTimeZone.forID("Asia/Tokyo")), new ChronosTimeFormatter(DateTimeZone.forID("Asia/Tokyo"), patternHourMinuteSecond)));
        chronosGui.addTimeGui(guiBuilder.buildTimeGui(new CityModel("New York", DateTimeZone.forID("America/New_York")), new ChronosTimeFormatter(DateTimeZone.forID("America/New_York"), patternHourMinuteSecond)));

        TimeChangeListener listener = new ModelToViewExchangeListener(timeModel, chronosGui);
        timeModel.addDataChangeListener(listener);
    }

    public void refreshPeriodic() {
        Date startTime = timeModel.getDateTime().toDate();
        new Timer().schedule(new ChronosTimerTask(timeModel), startTime, delayInMillis);
    }

}
