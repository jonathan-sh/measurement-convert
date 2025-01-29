package io.jonathan.converter.functions.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.jonathan.converter.Measurement.ACRES_PER_HOUR;
import static io.jonathan.converter.Measurement.SQUARE_METERS_PER_HOUR;

class SquareMetersHoursAcresHoursTest {

    SquareMetersHoursAcresHours item = new SquareMetersHoursAcresHours();

    @Test
    void from() {
        Assertions.assertEquals(SQUARE_METERS_PER_HOUR, item.from());
    }

    @Test
    void to() {
        Assertions.assertEquals(ACRES_PER_HOUR, item.to());
    }

    @Test
    void apply() {
        var acresHours = item.apply(4047.0);
        Assertions.assertEquals(1.0, acresHours);
    }

    @Test
    void reverse() {
        var squareMetersHours = item.reverse(1.0);
        Assertions.assertEquals(4047.0, squareMetersHours);
    }
}

