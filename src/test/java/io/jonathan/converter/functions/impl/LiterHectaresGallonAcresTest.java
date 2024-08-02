package io.jonathan.converter.functions.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.jonathan.converter.Measurement.GALLON_PER_ACRES;
import static io.jonathan.converter.Measurement.LITER_PER_HECTARES;

class LiterHectaresGallonAcresTest {


    LiterHectaresGallonAcres item = new LiterHectaresGallonAcres();

    @Test
    void from() {
        Assertions.assertEquals(LITER_PER_HECTARES, item.from());
    }

    @Test
    void to() {
        Assertions.assertEquals(GALLON_PER_ACRES, item.to());
    }

    @Test
    void apply() {
        var gallon = item.apply(100.00);
        Assertions.assertEquals(26.42007926023778, gallon);
    }

    @Test
    void reverse() {
        var liter = item.reverse(26.42007926023778);
        Assertions.assertEquals(100.00, liter);
    }
}