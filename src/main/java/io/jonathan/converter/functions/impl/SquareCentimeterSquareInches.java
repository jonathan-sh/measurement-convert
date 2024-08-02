package io.jonathan.converter.functions.impl;

import io.jonathan.converter.Measurement;
import io.jonathan.converter.functions.ConvertFunction;

import static io.jonathan.converter.Measurement.SQUARE_CENTIMETER;
import static io.jonathan.converter.Measurement.SQUARE_INCHES;

public class SquareCentimeterSquareInches implements ConvertFunction {
    @Override
    public Measurement from() {
        return SQUARE_CENTIMETER;
    }

    @Override
    public Measurement to() {
        return SQUARE_INCHES;
    }

    @Override
    public Double apply(Double squareCentimeters) {
        var squareInches = squareCentimeters / 6.452;
        return squareInches;
    }

    @Override
    public Double reverse(Double squareInches) {
        var squareCentimeter = squareInches * 6.452;
        return squareCentimeter;
    }
}
