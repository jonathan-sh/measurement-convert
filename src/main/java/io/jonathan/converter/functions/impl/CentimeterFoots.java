package io.jonathan.converter.functions.impl;

import io.jonathan.converter.Measurement;
import io.jonathan.converter.functions.ConvertFunction;

import static io.jonathan.converter.Measurement.CENTIMETER;
import static io.jonathan.converter.Measurement.FOOT;

public class CentimeterFoots implements ConvertFunction {
    @Override
    public Measurement from() {
        return CENTIMETER;
    }

    @Override
    public Measurement to() {
        return FOOT;
    }

    @Override
    public Double apply(Double centimeters) {
        return centimeters / 30.48;
    }

    @Override
    public Double reverse(Double foots) {
        return foots * 30.48;
    }
}
