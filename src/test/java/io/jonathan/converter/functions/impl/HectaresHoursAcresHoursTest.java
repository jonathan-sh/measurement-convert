package io.jonathan.converter.functions.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.jonathan.converter.Measurement.ACRES_PER_HOUR;
import static io.jonathan.converter.Measurement.HECTARES_PER_HOUR;


class HectaresHoursAcresHoursTest {

    HectaresHoursAcresHours item = new HectaresHoursAcresHours();

    @Test
    void from() {
        Assertions.assertEquals(HECTARES_PER_HOUR, item.from());
    }

    @Test
    void to() {
        Assertions.assertEquals(ACRES_PER_HOUR, item.to());
    }

    @Test
    void apply() {
        var acresHours = item.apply(1.0);
        Assertions.assertEquals(2.471, acresHours);
    }

    @Test
    void reverse() {
        var hectaresHours = item.reverse(2.471);
        Assertions.assertEquals(1.0, hectaresHours);
    }
}

