package de.idos.chronos.fx;

import java.util.TimerTask;

import javafx.application.Platform;

import org.joda.time.DateTime;

import de.idos.chronos.common.ChronosModel;

class FxTimerTask extends TimerTask {

    private final ChronosModel timeModel;
    private DateTime nextDateTime;

    public FxTimerTask(ChronosModel timeModel) {
        this.timeModel = timeModel;
        nextDateTime = timeModel.getDateTime();
    }

    @Override
    public void run() {
        Platform.runLater(new Runnable() {

            public void run() {
                nextDateTime = nextDateTime.plusSeconds(1);
                timeModel.setDateTime(nextDateTime);
            }
        });
    }

}