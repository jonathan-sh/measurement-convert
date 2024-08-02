package io.jonathan.converter.functions.impl;

import io.jonathan.converter.Measurement;
import io.jonathan.converter.functions.ConvertFunction;

import static io.jonathan.converter.Measurement.ACRES;
import static io.jonathan.converter.Measurement.SQUARE_METER;

public class SquareMeterAcres implements ConvertFunction {
    @Override
    public Measurement from() {
        return SQUARE_METER;
    }

    @Override
    public Measurement to() {
        return ACRES;
    }

    @Override
    public Double apply(Double squareMeter) {
        return squareMeter / 4047;
    }

    @Override
    public Double reverse(Double acres) {
        return acres * 4047;
    }
}
