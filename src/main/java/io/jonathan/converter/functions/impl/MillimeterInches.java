package io.jonathan.converter.functions.impl;

import io.jonathan.converter.Measurement;
import io.jonathan.converter.functions.ConvertFunction;

import static io.jonathan.converter.Measurement.INCHES;
import static io.jonathan.converter.Measurement.MILLIMETER;

public class MillimeterInches implements ConvertFunction {
    @Override
    public Measurement from() {
        return MILLIMETER;
    }

    @Override
    public Measurement to() {
        return INCHES;
    }

    @Override
    public Double apply(Double millimeter) {
        return millimeter / 25.4;
    }

    @Override
    public Double reverse(Double inches) {
        return inches * 25.4;
    }
}
