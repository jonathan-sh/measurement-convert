package io.jonathan.converter.functions.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.jonathan.converter.Measurement.SQUARE_CENTIMETER;
import static io.jonathan.converter.Measurement.SQUARE_INCHES;

class SquareCentimeterSquareInchesTest {
    SquareCentimeterSquareInches item = new SquareCentimeterSquareInches();

    @Test
    void from() {
        Assertions.assertEquals(SQUARE_CENTIMETER, item.from());
    }

    @Test
    void to() {
        Assertions.assertEquals(SQUARE_INCHES, item.to());
    }

    @Test
    void apply() {
        var squareInches = item.apply(645.2);
        Assertions.assertEquals(100.00000000000001, squareInches);
    }

    @Test
    void reverse() {
        var squareCentimeter = item.reverse(100.00);
        Assertions.assertEquals(645.2, squareCentimeter);
    }
}