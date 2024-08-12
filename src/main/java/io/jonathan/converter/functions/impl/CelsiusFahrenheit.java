package io.jonathan.converter.functions.impl;

import io.jonathan.converter.Measurement;
import io.jonathan.converter.functions.MeasurementConvertFunction;

import static io.jonathan.converter.Measurement.CELSIUS;
import static io.jonathan.converter.Measurement.FAHRENHEIT;

public class CelsiusFahrenheit implements MeasurementConvertFunction {
    @Override
    public Measurement from() {
        return CELSIUS;
    }

    @Override
    public Measurement to() {
        return FAHRENHEIT;
    }

    @Override
    public Double apply(Double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    @Override
    public Double reverse(Double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}
