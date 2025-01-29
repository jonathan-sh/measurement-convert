package io.jonathan.converter.functions.impl;

import io.jonathan.converter.Measurement;
import io.jonathan.converter.functions.MeasurementConvertFunction;


public class SquareMetersHoursHectaresHours implements MeasurementConvertFunction {
    @Override
    public Measurement from() {
        return Measurement.SQUARE_METERS_PER_HOUR;
    }

    @Override
    public Measurement to() {
        return Measurement.HECTARES_PER_HOUR;
    }

    @Override
    public Double apply(Double squareMetersPerHour) {
        return squareMetersPerHour / 10000; // Conversión de m²/h a ha/h
    }

    @Override
    public Double reverse(Double hectaresPerHour) {
        return hectaresPerHour * 10000; // Conversión de ha/h a m²/h
    }
}

