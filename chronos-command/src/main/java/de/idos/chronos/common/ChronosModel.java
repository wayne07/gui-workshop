package de.idos.chronos.common;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

public class ChronosModel {

    private final List<TimeChangeListener> listeners = new ArrayList<TimeChangeListener>();

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

    public void addDataChangeListener(TimeChangeListener listener) {
        listeners.add(listener);
    }

    private void informListeners() {
        for (TimeChangeListener listener : listeners) {
            listener.timeChanged();
        }

    }

}
