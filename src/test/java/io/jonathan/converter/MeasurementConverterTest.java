package io.jonathan.converter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MeasurementConverterTest {

    @Test
    @DisplayName("Check null value when we try apply the system")
    void applySystem() {
        var resul = MeasurementConverter.applySystem(null, null);
        assertTrue(resul.isEmpty());
    }

    @Test
    @DisplayName("Check null value when we try apply the imperial system")
    void applyImperialSystem() {
        var resul = MeasurementConverter.applyImperialSystem(null);
        assertTrue(resul.isEmpty());
    }

    @Test
    @DisplayName("Check null value when we try apply the metric system")
    void applyMetricSystem() {
        var resul = MeasurementConverter.applyMetricSystem(null);
        assertTrue(resul.isEmpty());
    }
}