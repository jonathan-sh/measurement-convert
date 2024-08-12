package io.jonathan.converter.functions.impl;

import io.jonathan.converter.Measurement;
import io.jonathan.converter.functions.MeasurementConvertFunction;

import static io.jonathan.converter.Measurement.HECTARES;
import static io.jonathan.converter.Measurement.SQUARE_METER;

public class SquareMeterHectares implements MeasurementConvertFunction {
    @Override
    public Measurement from() {
        return SQUARE_METER;
    }

    @Override
    public Measurement to() {
        return HECTARES;
    }

    @Override
    public Double apply(Double squareMeter) {
        var hectare = squareMeter / 10000;
        return hectare;
    }

    @Override
    public Double reverse(Double hectare) {
        var squareMeter = hectare * 10000;
        return squareMeter;
    }
}
