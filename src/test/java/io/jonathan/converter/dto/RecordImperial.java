package io.jonathan.converter.dto;


import io.jonathan.converter.MeasurementConvert;

import java.time.LocalDateTime;

import static io.jonathan.converter.Measurement.CELSIUS;
import static io.jonathan.converter.Measurement.FAHRENHEIT;


public record RecordImperial(
        @MeasurementConvert(current = FAHRENHEIT, metric = CELSIUS, imperial = FAHRENHEIT)
        String temperature,

        LocalDateTime now
) {

}
