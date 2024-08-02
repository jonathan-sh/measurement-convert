package io.jonathan.converter.functions.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.jonathan.converter.Measurement.SQUARE_CENTIMETER;
import static io.jonathan.converter.Measurement.SQUARE_FOOT;

class SquareCentimeterSquareFootsTest {

    SquareCentimeterSquareFoots item = new SquareCentimeterSquareFoots();

    @Test
    void from() {
        Assertions.assertEquals(SQUARE_CENTIMETER, item.from());
    }

    @Test
    void to() {
        Assertions.assertEquals(SQUARE_FOOT, item.to());
    }

    @Test
    void apply() {
        var squareFoot = item.apply(929.00);
        Assertions.assertEquals(1, squareFoot);
    }

    @Test
    void reverse() {
        var squareCentimeter = item.reverse(1.0);
        Assertions.assertEquals(929.00, squareCentimeter);
    }
}