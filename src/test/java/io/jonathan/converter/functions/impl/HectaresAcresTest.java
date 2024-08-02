package io.jonathan.converter.functions.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.jonathan.converter.Measurement.ACRES;
import static io.jonathan.converter.Measurement.HECTARES;

class HectaresAcresTest {

    HectaresAcres item = new HectaresAcres();

    @Test
    void from() {
        Assertions.assertEquals(HECTARES, item.from());
    }

    @Test
    void to() {
        Assertions.assertEquals(ACRES, item.to());
    }

    @Test
    void apply() {
        var acres = item.apply(1.0);
        Assertions.assertEquals(2.471, acres);
    }

    @Test
    void reverse() {
        var hectares = item.reverse(2.471);
        Assertions.assertEquals(1.0, hectares);
    }
}