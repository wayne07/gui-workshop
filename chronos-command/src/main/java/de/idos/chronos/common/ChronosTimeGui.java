package de.idos.chronos.common;

import java.awt.Component;

import org.joda.time.DateTime;

public interface ChronosTimeGui {

    void setTime(DateTime time);

    Component getComponent();

}
