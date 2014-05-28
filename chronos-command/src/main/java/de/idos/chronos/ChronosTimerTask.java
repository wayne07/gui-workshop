package de.idos.chronos;

import java.util.TimerTask;

import org.joda.time.DateTime;

public class ChronosTimerTask extends TimerTask {

    private final GuiUpdater guiUpdater;
    private DateTime nextDateTime;

    public ChronosTimerTask(GuiUpdater guiUpdater, DateTime startDateTime) {
        this.guiUpdater = guiUpdater;
        this.nextDateTime = startDateTime;
    }

    @Override
    public void run() {
        nextDateTime = nextDateTime.plusSeconds(1);
        guiUpdater.updateTime(nextDateTime.toLocalTime());
    }

}