package io.jonathan.converter.functions.impl;

import io.jonathan.converter.Measurement;
import io.jonathan.converter.functions.MeasurementConvertFunction;


public class HectaresHoursAcresHours implements MeasurementConvertFunction {
    @Override
    public Measurement from() {
        return Measurement.HECTARES_PER_HOUR;
    }

    @Override
    public Measurement to() {
        return Measurement.ACRES_PER_HOUR;
    }

    @Override
    public Double apply(Double hectaresHours) {
        return hectaresHours * 2.471;
    }

    @Override
    public Double reverse(Double acresHours) {
        return acresHours / 2.471;
    }
}
