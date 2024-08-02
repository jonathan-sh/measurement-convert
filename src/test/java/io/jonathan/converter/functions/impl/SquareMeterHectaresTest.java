package io.jonathan.converter.functions.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.jonathan.converter.Measurement.HECTARES;
import static io.jonathan.converter.Measurement.SQUARE_METER;

class SquareMeterHectaresTest {


    SquareMeterHectares item = new SquareMeterHectares();

    @Test
    void from() {
        Assertions.assertEquals(SQUARE_METER, item.from());
    }

    @Test
    void to() {
        Assertions.assertEquals(HECTARES, item.to());
    }

    @Test
    void apply() {
        var hectare = item.apply(100.00);
        Assertions.assertEquals(0.01, hectare);
    }

    @Test
    void reverse() {
        var squareMeter = item.reverse(0.01);
        Assertions.assertEquals(100.00, squareMeter);
    }
}