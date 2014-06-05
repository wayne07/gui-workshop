package de.idos.chronos.swing;

import de.idos.chronos.common.ChronosTimeGui;
import de.idos.chronos.common.GuiBuilder;
import de.idos.chronos.common.format.ChronosFormatter;

public class SwingGuiBuilder implements GuiBuilder {

    public ChronosTimeGui buildTimeGui(String guiName, ChronosFormatter chronosFormatter) {
        return new TimePanel(guiName, chronosFormatter);
    }

}
