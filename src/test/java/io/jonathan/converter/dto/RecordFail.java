package io.jonathan.converter.dto;


import io.jonathan.converter.MeasurementConvert;

import java.time.LocalDateTime;

import static io.jonathan.converter.Measurement.CELSIUS;
import static io.jonathan.converter.Measurement.FAHRENHEIT;
import static io.jonathan.converter.Measurement.MILES_PER_HOUR;


public record RecordFail(
        @MeasurementConvert(current = CELSIUS, metric = MILES_PER_HOUR, imperial = FAHRENHEIT)
        String temperature,

        LocalDateTime now
) {

}
