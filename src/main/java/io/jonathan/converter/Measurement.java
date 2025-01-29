package io.jonathan.converter;

public enum Measurement {
    ACRES("ac"),
    HECTARES("ha"),
    CENTIMETER("cm"),
    SQUARE_CENTIMETER("cm²"),
    SQUARE_FOOT("ft²"),
    SQUARE_INCHES("in²"),
    FOOT("ft"),
    MILLIMETER("mm"),
    INCHES("in"),
    CELSIUS("ºC"),
    FAHRENHEIT("ºF"),
    KILOMETER_PER_HOUR("km/h"),
    MILES_PER_HOUR("m/h"),
    SQUARE_METER("m²"),
    LITER("l"),
    GALLON("gal"),
    PERCENTAGE("%"),
    RPM("rpm"),
    LITER_PER_HECTARES("l/ha"),
    GALLON_PER_ACRES("gal/a"),
    WATTS_PER_SQUARE_METTER("w/m²"),
    NONE(""),
    PASCAL("Pa"),
    POUNDS_PER_SQUARE_INCH("PSI"),
    HECTARES_PER_HOUR("ha/h"),
    ACRES_PER_HOUR("acre/h"),
    SQUARE_METERS_PER_HOUR("m²/h");

    public final String symbol;

    Measurement(String symbol) {
        this.symbol = symbol;
    }
}
