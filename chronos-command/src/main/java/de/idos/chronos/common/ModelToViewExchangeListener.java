package de.idos.chronos.common;

public class ModelToViewExchangeListener implements TimeChangeListener {

    private final ChronosModel model;
    private final ChronosGui view;

    public ModelToViewExchangeListener(ChronosModel model, ChronosGui chronosGui) {
        this.model = model;
        this.view = chronosGui;
    }

    public void timeChanged() {
        view.setTime(model.getDateTime());
    }

}
