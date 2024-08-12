package io.jonathan.converter.functions.impl;

import io.jonathan.converter.Measurement;
import io.jonathan.converter.functions.MeasurementConvertFunction;

import static io.jonathan.converter.Measurement.KILOMETER_PER_HOUR;
import static io.jonathan.converter.Measurement.MILES_PER_HOUR;

public class KilometerHourMilesHour implements MeasurementConvertFunction {
    @Override
    public Measurement from() {
        return KILOMETER_PER_HOUR;
    }

    @Override
    public Measurement to() {
        return MILES_PER_HOUR;
    }

    @Override
    public Double apply(Double kmh) {
        return kmh / 1.60934;
    }

    @Override
    public Double reverse(Double mph) {
        return mph * 1.60934;
    }
}
