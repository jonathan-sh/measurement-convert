package io.jonathan.converter.demo;

import io.jonathan.converter.MeasurementConvert;

import static io.jonathan.converter.Measurement.CELSIUS;
import static io.jonathan.converter.Measurement.FAHRENHEIT;

public record ExampleEntity(
        //the value in numeric form, which receives <conversion>
        @MeasurementConvert(current = CELSIUS, metric = CELSIUS, imperial = FAHRENHEIT)
        Double temperatureNum,
        //the value in text form, which receives <conversion> + <symbol>
        @MeasurementConvert(current = CELSIUS, metric = CELSIUS, imperial = FAHRENHEIT)
        String temperatureTxt,
        //other values of the entity remained untouched
        String notTouchValue
) {
}
