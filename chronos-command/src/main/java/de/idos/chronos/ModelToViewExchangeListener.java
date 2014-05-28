package de.idos.chronos;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class ModelToViewExchangeListener implements ChangeListener {

    private final ChronosModel model;
    private final ChronosGui view;

    public ModelToViewExchangeListener(ChronosModel model, ChronosGui chronosGui) {
        this.model = model;
        this.view = chronosGui;
    }

    public void stateChanged(ChangeEvent e) {
        view.setTime(model.getDateTime());
    }

}
