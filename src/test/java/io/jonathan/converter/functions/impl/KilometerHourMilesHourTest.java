package io.jonathan.converter.functions.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.jonathan.converter.Measurement.KILOMETER_PER_HOUR;
import static io.jonathan.converter.Measurement.MILES_PER_HOUR;

class KilometerHourMilesHourTest {

    KilometerHourMilesHour item = new KilometerHourMilesHour();

    @Test
    void from() {
        Assertions.assertEquals(KILOMETER_PER_HOUR, item.from());
    }

    @Test
    void to() {
        Assertions.assertEquals(MILES_PER_HOUR, item.to());
    }

    @Test
    void apply() {
        var mph = item.apply(160.934);
        Assertions.assertEquals(100.00, mph);
    }

    @Test
    void reverse() {
        var kph = item.reverse(100.00);
        Assertions.assertEquals(160.934, kph);
    }
}