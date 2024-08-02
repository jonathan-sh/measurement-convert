package io.jonathan.converter.functions.impl;

import io.jonathan.converter.Measurement;
import io.jonathan.converter.functions.ConvertFunction;

import static io.jonathan.converter.Measurement.CENTIMETER;
import static io.jonathan.converter.Measurement.INCHES;

public class CentimeterInches implements ConvertFunction {
    @Override
    public Measurement from() {
        return CENTIMETER;
    }

    @Override
    public Measurement to() {
        return INCHES;
    }

    @Override
    public Double apply(Double centimeters) {
        var inches = centimeters / 2.54;
        return inches;
    }

    @Override
    public Double reverse(Double inches) {
        var centimeter = inches * 2.54;
        return centimeter;
    }
}
