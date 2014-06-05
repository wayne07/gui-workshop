package de.idos.chronos.common;

import java.util.Date;
import java.util.Timer;

import org.joda.time.DateTimeZone;

public class ChronosPresenter {

    private final long delayInMillis = 1000l;
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
        Date startTime = timeModel.getDateTime().toDate();
        new Timer().schedule(new ChronosTimerTask(timeModel), startTime, delayInMillis);
    }

}
