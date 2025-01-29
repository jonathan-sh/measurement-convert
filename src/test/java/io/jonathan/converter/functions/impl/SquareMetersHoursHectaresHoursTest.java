package io.jonathan.converter.functions.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.jonathan.converter.Measurement.HECTARES_PER_HOUR;
import static io.jonathan.converter.Measurement.SQUARE_METERS_PER_HOUR;

class SquareMetersHoursHectaresHoursTest {

    SquareMetersHoursHectaresHours item = new SquareMetersHoursHectaresHours();

    @Test
    void from() {
        Assertions.assertEquals(SQUARE_METERS_PER_HOUR, item.from());
    }

    @Test
    void to() {
        Assertions.assertEquals(HECTARES_PER_HOUR, item.to());
    }

    @Test
    void apply() {
        var hectaresHours = item.apply(10000.0);
        Assertions.assertEquals(1.0, hectaresHours);
    }

    @Test
    void reverse() {
        var squareMetersHours = item.reverse(1.0);
        Assertions.assertEquals(10000.0, squareMetersHours);
    }
}

