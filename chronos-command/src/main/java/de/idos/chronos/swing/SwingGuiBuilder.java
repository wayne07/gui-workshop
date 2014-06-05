package de.idos.chronos.swing;

import de.idos.chronos.common.ChronosTimeGui;
import de.idos.chronos.common.CityModel;
import de.idos.chronos.common.GuiBuilder;
import de.idos.chronos.common.format.ChronosFormatter;

public class SwingGuiBuilder implements GuiBuilder {

    public ChronosTimeGui buildTimeGui(CityModel cityModel, ChronosFormatter chronosFormatter) {
        return new TimePanel(cityModel.nameOfCity, cityModel.dateTimeZone, chronosFormatter);
    }

}
