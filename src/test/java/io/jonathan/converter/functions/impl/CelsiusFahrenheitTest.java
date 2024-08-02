package io.jonathan.converter.functions.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.jonathan.converter.Measurement.CELSIUS;
import static io.jonathan.converter.Measurement.FAHRENHEIT;


class CelsiusFahrenheitTest {

    CelsiusFahrenheit item = new CelsiusFahrenheit();

    @Test
    void from() {
        Assertions.assertEquals(CELSIUS, item.from());
    }

    @Test
    void to() {
        Assertions.assertEquals(FAHRENHEIT, item.to());
    }

    @Test
    void apply() {
        var fahrenheit = item.apply(38.00);
        Assertions.assertEquals(100.4, fahrenheit);
    }

    @Test
    void reverse() {
        var celsius = item.reverse(100.4);
        Assertions.assertEquals(38.00, celsius);
    }
}