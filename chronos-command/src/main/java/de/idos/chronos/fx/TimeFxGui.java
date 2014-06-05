package de.idos.chronos.fx;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import org.joda.time.DateTime;

import de.idos.chronos.common.ChronosTimeGui;
import de.idos.chronos.common.format.ChronosFormatter;

public class TimeFxGui implements ChronosTimeGui {

    private final Label lblTime = new Label();
    private final HBox pane = new HBox();

    private final ChronosFormatter formatter;

    public TimeFxGui(String name, ChronosFormatter chronosFormatter) {
        this.formatter = chronosFormatter;
        createPanelWithTime(name);
    }

    public Pane createPanelWithTime(String name) {
        Label label = new Label("Uhrzeit in " + name + ": ");
        if (name.isEmpty()) {
            label.setText("Uhrzeit: ");
        }

        pane.getChildren().addAll(label, lblTime);
        return pane;
    }

    public Pane getComponent() {
        return pane;
    }

    public void setTime(DateTime time) {
        lblTime.setText(formatter.format(time));
    }

}
