package de.idos.chronos.common;

import java.util.Timer;
import java.util.TimerTask;

import org.joda.time.DateTime;

public class ChronosPresenter {

    private final ChronosModel model;

    public ChronosPresenter(ChronosGui chronosGui, ChronosModel model) {
        this.model = model;

        TimeChangeListener listener = new ModelToViewExchangeListener(model, chronosGui);
        model.addDataChangeListener(listener);
    }

    public void refreshPeriodic() {
        Timer timer = new Timer();

        final DateTime startDateTime = model.getDateTime();

        TimerTask timerTask = new TimerTask() {

            DateTime nextDateTime = startDateTime;

            @Override
            public void run() {
                nextDateTime = nextDateTime.plusSeconds(1);
                model.setDateTime(nextDateTime);
            }

        };
        long delayInMillis = 1000l;
        timer.schedule(timerTask, startDateTime.toDate(), delayInMillis);
    }

}
