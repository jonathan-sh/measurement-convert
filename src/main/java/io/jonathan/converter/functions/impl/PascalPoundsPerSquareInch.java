package io.jonathan.converter.functions.impl;

import io.jonathan.converter.Measurement;
import io.jonathan.converter.functions.MeasurementConvertFunction;

import static io.jonathan.converter.Measurement.PASCAL;
import static io.jonathan.converter.Measurement.POUNDS_PER_SQUARE_INCH;

public class PascalPoundsPerSquareInch implements MeasurementConvertFunction {
    @Override
    public Measurement from() {
        return PASCAL;
    }

    @Override
    public Measurement to() {
        return POUNDS_PER_SQUARE_INCH;
    }

    @Override
    public Double apply(Double pascal) {
        return pascal * 0.00014503773800722;
    }

    @Override
    public Double reverse(Double poundsPerSquareInch) {
        return poundsPerSquareInch / 0.00014503773800722;
    }
}
