package io.jonathan.converter.dto;

import io.jonathan.converter.MeasurementConvert;

import java.time.LocalDateTime;
import java.util.List;

import static io.jonathan.converter.Measurement.CELSIUS;
import static io.jonathan.converter.Measurement.FAHRENHEIT;


public class ClassMetricMultiTypesDeepValued {
    public LocalDateTime now;

    @MeasurementConvert(current = CELSIUS, metric = CELSIUS, imperial = FAHRENHEIT)
    public String temperatureInString;

    @MeasurementConvert(current = CELSIUS, metric = CELSIUS, imperial = FAHRENHEIT)
    public Double temperatureInDouble;

    @MeasurementConvert
    public ClassMetric classMetric;

    @MeasurementConvert
    public RecordMetric recordMetric;

    @MeasurementConvert
    public InternalClass internalClass;

    @MeasurementConvert
    public InternalRecord internalRecord;

    @MeasurementConvert(current = CELSIUS, metric = CELSIUS, imperial = FAHRENHEIT)
    public List<String> temperatureInStringList;

    @MeasurementConvert(current = CELSIUS, metric = CELSIUS, imperial = FAHRENHEIT)
    public List<Double> temperatureInDoubleList;

    public ClassMetricMultiTypesDeepValued(String temperatureInString,
                                           LocalDateTime now,
                                           ClassMetric classMetric,
                                           RecordMetric recordMetric,
                                           InternalClass internalClass, InternalRecord internalRecord) {
        this.temperatureInString = temperatureInString;
        this.now = now;
        this.classMetric = classMetric;
        this.recordMetric = recordMetric;
        this.internalClass = internalClass;
        this.internalRecord = internalRecord;
    }

    public static class InternalClass {
        @MeasurementConvert(current = CELSIUS, metric = CELSIUS, imperial = FAHRENHEIT)
        public String temperature;

        public LocalDateTime now;

        public InternalClass(String temperature, LocalDateTime now) {
            this.temperature = temperature;
            this.now = now;
        }
    }

    public record InternalRecord(
            @MeasurementConvert(current = CELSIUS, metric = CELSIUS, imperial = FAHRENHEIT)
            String temperature,

            LocalDateTime now) {
    }
}
