package io.jonathan.converter.functions.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.jonathan.converter.Measurement.CENTIMETER;
import static io.jonathan.converter.Measurement.INCHES;

class CentimeterInchesTest {

    CentimeterInches item = new CentimeterInches();

    @Test
    void from() {
        Assertions.assertEquals(CENTIMETER, item.from());
    }

    @Test
    void to() {
        Assertions.assertEquals(INCHES, item.to());
    }

    @Test
    void apply() {
        var inches = item.apply(2.54);
        Assertions.assertEquals(1.0, inches);
    }

    @Test
    void reverse() {
        var centimeters = item.reverse(1.0);
        Assertions.assertEquals(2.54, centimeters);
    }
}