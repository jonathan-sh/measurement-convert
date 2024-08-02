package io.jonathan.converter.functions.impl;

import io.jonathan.converter.Measurement;
import io.jonathan.converter.functions.ConvertFunction;

import static io.jonathan.converter.Measurement.GALLON;
import static io.jonathan.converter.Measurement.LITER;

public class LiterGallon implements ConvertFunction {
    @Override
    public Measurement from() {
        return LITER;
    }

    @Override
    public Measurement to() {
        return GALLON;
    }

    @Override
    public Double apply(Double liter) {
        return liter / 3.785;
    }

    @Override
    public Double reverse(Double gallon) {
        return gallon * 3.785;
    }
}
