package io.jonathan.converter.functions.impl;

import io.jonathan.converter.Measurement;
import io.jonathan.converter.functions.MeasurementConvertFunction;

import static io.jonathan.converter.Measurement.ACRES;
import static io.jonathan.converter.Measurement.HECTARES;

public class HectaresAcres implements MeasurementConvertFunction {
    @Override
    public Measurement from() {
        return HECTARES;
    }

    @Override
    public Measurement to() {
        return ACRES;
    }

    @Override
    public Double apply(Double hectares) {
        return hectares * 2.471;
    }

    @Override
    public Double reverse(Double acres) {
        return acres / 2.471;
    }
}
