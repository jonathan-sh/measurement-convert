package io.jonathan.converter.functions.impl;

import io.jonathan.converter.Measurement;
import io.jonathan.converter.functions.ConvertFunction;

import static io.jonathan.converter.Measurement.GALLON_PER_ACRES;
import static io.jonathan.converter.Measurement.LITER_PER_HECTARES;

public class LiterHectaresGallonAcres implements ConvertFunction {
    @Override
    public Measurement from() {
        return LITER_PER_HECTARES;
    }

    @Override
    public Measurement to() {
        return GALLON_PER_ACRES;
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
