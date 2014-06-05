package de.idos.chronos.fx;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import org.joda.time.DateTime;

import de.idos.chronos.common.ChronosGui;
import de.idos.chronos.common.ChronosTimeGui;

public class ChronosFxGui implements ChronosGui {

    private final GridPane canvas = new GridPane();

    private final List<TimeFxGui> nodes = new ArrayList<TimeFxGui>();

    public void setTime(DateTime time) {
        for (TimeFxGui panel : nodes) {
            panel.setTime(time);
        }
    }

    public void addTimeGui(ChronosTimeGui timeGui) {
        nodes.add((TimeFxGui)timeGui);
    }

    public Pane getComponent() {
        List<Node> list = new ArrayList<Node>();
        int rowIndex = 0;
        for (TimeFxGui node : nodes) {
            list.add(node.getComponent());
            canvas.addRow(rowIndex++, node.getComponent());
        }
        return canvas;
    }
}
