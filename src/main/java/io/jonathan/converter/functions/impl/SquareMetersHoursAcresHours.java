package io.jonathan.converter.functions.impl;

import io.jonathan.converter.Measurement;
import io.jonathan.converter.functions.MeasurementConvertFunction;

public class SquareMetersHoursAcresHours implements MeasurementConvertFunction {
    @Override
    public Measurement from() {
        return Measurement.SQUARE_METERS_PER_HOUR;
    }

    @Override
    public Measurement to() {
        return Measurement.ACRES_PER_HOUR;
    }

    @Override
    public Double apply(Double squareMetersPerHour) {
        return squareMetersPerHour / 4047;
    }

    @Override
    public Double reverse(Double acresPerHour) {
        return acresPerHour * 4047;
    }
}

