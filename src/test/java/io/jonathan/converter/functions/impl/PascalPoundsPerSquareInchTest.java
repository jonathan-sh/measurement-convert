package io.jonathan.converter.functions.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.jonathan.converter.Measurement.PASCAL;
import static io.jonathan.converter.Measurement.POUNDS_PER_SQUARE_INCH;

class PascalPoundsPerSquareInchTest {


    PascalPoundsPerSquareInch item = new PascalPoundsPerSquareInch();

    @Test
    void from() {
        Assertions.assertEquals(PASCAL, item.from());
    }

    @Test
    void to() {
        Assertions.assertEquals(POUNDS_PER_SQUARE_INCH, item.to());
    }

    @Test
    void apply() {
        var pascal = item.apply(100.0);
        Assertions.assertEquals(0.014503773800722, pascal);
    }

    @Test
    void reverse() {
        var poundsPerSquareInch = item.reverse(0.014503773800722);
        Assertions.assertEquals(100, poundsPerSquareInch);
    }
}