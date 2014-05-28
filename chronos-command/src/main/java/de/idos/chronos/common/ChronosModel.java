package de.idos.chronos.common;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.joda.time.DateTime;

public class ChronosModel {

    private final List<ChangeListener> listeners = new ArrayList<ChangeListener>();

    private DateTime dateTime;

    public ChronosModel(DateTime startTime) {
        this.dateTime = startTime;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
        informListeners();
    }

    public void addDataChangeListener(ChangeListener listener) {
        listeners.add(listener);
    }

    private void informListeners() {
        for (ChangeListener listener : listeners) {
            listener.stateChanged(new ChangeEvent("date has changed"));
        }

    }

}
