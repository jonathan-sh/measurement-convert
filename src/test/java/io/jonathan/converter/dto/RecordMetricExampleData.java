package io.jonathan.converter.dto;

import io.jonathan.converter.MeasurementConvert;

import java.time.LocalDateTime;

import static io.jonathan.converter.Measurement.CELSIUS;
import static io.jonathan.converter.Measurement.FAHRENHEIT;


public record RecordMetricExampleData(
        @MeasurementConvert(current = CELSIUS, metric = CELSIUS, imperial = FAHRENHEIT)
        String temperature,

        LocalDateTime now
) {

}
