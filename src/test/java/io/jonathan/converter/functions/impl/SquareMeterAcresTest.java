package io.jonathan.converter.functions.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.jonathan.converter.Measurement.ACRES;
import static io.jonathan.converter.Measurement.SQUARE_METER;

class SquareMeterAcresTest {


    SquareMeterAcres item = new SquareMeterAcres();

    @Test
    void from() {
        Assertions.assertEquals(SQUARE_METER, item.from());
    }

    @Test
    void to() {
        Assertions.assertEquals(ACRES, item.to());
    }

    @Test
    void apply() {
        var acres = item.apply(100.00);
        Assertions.assertEquals(0.024709661477637757, acres);
    }

    @Test
    void reverse() {
        var squareCentimeter = item.reverse(0.024709661477637757);
        Assertions.assertEquals(100.00, squareCentimeter);
    }
}