package io.jonathan.converter.functions.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.jonathan.converter.Measurement.INCHES;
import static io.jonathan.converter.Measurement.MILLIMETER;

class MillimeterInchesTest {

    MillimeterInches item = new MillimeterInches();

    @Test
    void from() {
        Assertions.assertEquals(MILLIMETER, item.from());
    }

    @Test
    void to() {
        Assertions.assertEquals(INCHES, item.to());
    }

    @Test
    void apply() {
        var inches = item.apply(2540.00);
        Assertions.assertEquals(100.00, inches);
    }

    @Test
    void reverse() {
        var millimeter = item.reverse(100.00);
        Assertions.assertEquals(2540, millimeter);
    }
}