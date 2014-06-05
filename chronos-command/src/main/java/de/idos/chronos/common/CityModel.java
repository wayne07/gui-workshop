package de.idos.chronos.common;

import org.joda.time.DateTimeZone;

public class CityModel {

    public final String nameOfCity;
    public final DateTimeZone dateTimeZone;

    public CityModel(String nameOfCity, DateTimeZone dateTimeZone) {
        this.nameOfCity = nameOfCity;
        this.dateTimeZone = dateTimeZone;
    }

}
