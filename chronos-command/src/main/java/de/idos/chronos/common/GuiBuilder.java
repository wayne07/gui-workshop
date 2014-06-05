package de.idos.chronos.common;

import de.idos.chronos.common.format.ChronosFormatter;

public interface GuiBuilder {

    ChronosTimeGui buildTimeGui(String guiName, ChronosFormatter chronosFormatter);

}
