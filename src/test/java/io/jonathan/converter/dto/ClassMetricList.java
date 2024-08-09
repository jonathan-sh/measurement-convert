package io.jonathan.converter.dto;


import io.jonathan.converter.MeasurementConvert;

import java.time.LocalDateTime;
import java.util.List;

import static io.jonathan.converter.Measurement.CELSIUS;
import static io.jonathan.converter.Measurement.FAHRENHEIT;


public class ClassMetricList {
    @MeasurementConvert(current = CELSIUS, metric = CELSIUS, imperial = FAHRENHEIT)
    public Double temperature;

    @MeasurementConvert(current = CELSIUS, metric = CELSIUS, imperial = FAHRENHEIT)
    public List<Double> temperatureList;

    @MeasurementConvert(current = CELSIUS, metric = CELSIUS, imperial = FAHRENHEIT)
    public List<String> temperatureListString;

    @MeasurementConvert(current = CELSIUS, metric = CELSIUS, imperial = FAHRENHEIT)
    public List<ClassMetric> temperatureListObject;

    public LocalDateTime now;

    public ClassMetricList(Double temperature, LocalDateTime now) {
        this.temperature = temperature;
        this.now = now;
    }
}