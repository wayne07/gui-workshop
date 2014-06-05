package de.idos.chronos.common;

import java.util.TimerTask;

import org.joda.time.DateTime;

class ChronosTimerTask extends TimerTask {

    private final ChronosModel timeModel;
    private DateTime nextDateTime;

    public ChronosTimerTask(ChronosModel timeModel) {
        this.timeModel = timeModel;
        nextDateTime = timeModel.getDateTime();
    }

    @Override
    public void run() {
        nextDateTime = nextDateTime.plusSeconds(1);
        timeModel.setDateTime(nextDateTime);
    }

}