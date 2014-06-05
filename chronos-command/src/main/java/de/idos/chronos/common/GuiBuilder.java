package de.idos.chronos.common;

import de.idos.chronos.common.format.ChronosFormatter;

public interface GuiBuilder {

    ChronosTimeGui buildTimeGui(CityModel cityModel, ChronosFormatter chronosFormatter);

}
