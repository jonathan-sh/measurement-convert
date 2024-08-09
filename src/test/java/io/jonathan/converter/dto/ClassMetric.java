package io.jonathan.converter.dto;


import io.jonathan.converter.MeasurementConvert;

import java.time.LocalDateTime;

import static io.jonathan.converter.Measurement.CELSIUS;
import static io.jonathan.converter.Measurement.FAHRENHEIT;


public class ClassMetric {
    @MeasurementConvert(current = CELSIUS, metric = CELSIUS, imperial = FAHRENHEIT)
    public String temperature;

    public LocalDateTime now;

    public ClassMetric(String temperature, LocalDateTime now) {
        this.temperature = temperature;
        this.now = now;
    }
}