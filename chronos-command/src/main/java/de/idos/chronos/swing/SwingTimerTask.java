package de.idos.chronos.swing;

import java.util.TimerTask;

import javax.swing.SwingUtilities;

import org.joda.time.DateTime;

import de.idos.chronos.common.ChronosModel;

class SwingTimerTask extends TimerTask {

    private final ChronosModel timeModel;
    private DateTime nextDateTime;

    public SwingTimerTask(ChronosModel timeModel) {
        this.timeModel = timeModel;
        nextDateTime = timeModel.getDateTime();
    }

    @Override
    public void run() {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                nextDateTime = nextDateTime.plusSeconds(1);
                timeModel.setDateTime(nextDateTime);
            }
        });
    }

}