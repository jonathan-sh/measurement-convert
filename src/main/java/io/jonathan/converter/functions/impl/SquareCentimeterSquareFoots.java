package io.jonathan.converter.functions.impl;

import io.jonathan.converter.Measurement;
import io.jonathan.converter.functions.MeasurementConvertFunction;

import static io.jonathan.converter.Measurement.SQUARE_CENTIMETER;
import static io.jonathan.converter.Measurement.SQUARE_FOOT;

public class SquareCentimeterSquareFoots implements MeasurementConvertFunction {
    @Override
    public Measurement from() {
        return SQUARE_CENTIMETER;
    }

    @Override
    public Measurement to() {
        return SQUARE_FOOT;
    }

    @Override
    public Double apply(Double squareCentimeters) {
        var squareFoot = squareCentimeters / 929;
        return squareFoot;
    }

    @Override
    public Double reverse(Double squareFoots) {
        var squareCentimeter = squareFoots * 929;
        return squareCentimeter;
    }
}
