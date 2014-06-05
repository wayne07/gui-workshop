package de.idos.chronos.common;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.joda.time.DateTimeZone;

import de.idos.chronos.common.format.ChronosTimeFormatter;

public class ChronosPresenter {

    private final long delayInMillis = 1000l;
    private final String patternHourMinuteSecond = "HH:mm:ss";
    private final String patternHourMinute = "HH:mm";

    private final ChronosModel timeModel;

    public ChronosPresenter(ChronosGui chronosGui, ChronosModel timeModel, GuiBuilder guiBuilder) {
        this.timeModel = timeModel;

        chronosGui.addTimeGui(guiBuilder.buildTimeGui("", new ChronosTimeFormatter(DateTimeZone.forID("Europe/Athens"), patternHourMinute)));
        chronosGui.addTimeGui(guiBuilder.buildTimeGui("UTC", new ChronosTimeFormatter(DateTimeZone.forID("UTC"), patternHourMinuteSecond)));
        chronosGui.addTimeGui(guiBuilder.buildTimeGui("London", new ChronosTimeFormatter(DateTimeZone.forID("Europe/London"), patternHourMinuteSecond)));
        chronosGui.addTimeGui(guiBuilder.buildTimeGui("Frankfurt", new ChronosTimeFormatter(DateTimeZone.forID("Europe/Berlin"), patternHourMinuteSecond)));
        chronosGui.addTimeGui(guiBuilder.buildTimeGui("Tokyo", new ChronosTimeFormatter(DateTimeZone.forID("Asia/Tokyo"), patternHourMinuteSecond)));
        chronosGui.addTimeGui(guiBuilder.buildTimeGui("New York", new ChronosTimeFormatter(DateTimeZone.forID("America/New_York"), patternHourMinuteSecond)));

        TimeChangeListener listener = new ModelToViewExchangeListener(timeModel, chronosGui);
        timeModel.addDataChangeListener(listener);
    }

    public void refreshPeriodic(TimerTask timerTask) {
        Date startTime = timeModel.getDateTime().toDate();
        new Timer().schedule(timerTask, startTime, delayInMillis);
    }

}
