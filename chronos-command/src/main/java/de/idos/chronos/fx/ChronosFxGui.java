package de.idos.chronos.fx;

import javafx.scene.layout.Pane;

import org.joda.time.DateTime;

import de.idos.chronos.common.ChronosGui;
import de.idos.chronos.common.ChronosTimeGui;

public class ChronosFxGui implements ChronosGui {

    public void setTime(DateTime time) {

    }

    public Pane getComponent() {
        Pane canvas = new Pane();
        return canvas;
    }

    public void addTimeGui(ChronosTimeGui timeGui) {

    }

}
