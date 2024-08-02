package io.jonathan.converter.functions.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.jonathan.converter.Measurement.CENTIMETER;
import static io.jonathan.converter.Measurement.FOOT;

class CentimeterFootsTest {

    CentimeterFoots item = new CentimeterFoots();

    @Test
    void from() {
        Assertions.assertEquals(CENTIMETER, item.from());
    }

    @Test
    void to() {
        Assertions.assertEquals(FOOT, item.to());
    }

    @Test
    void apply() {
        var foots = item.apply(3048.00);
        Assertions.assertEquals(100.00, foots);
    }

    @Test
    void reverse() {
        var centimeters = item.reverse(100.00);
        Assertions.assertEquals(3048.00, centimeters);
    }
}