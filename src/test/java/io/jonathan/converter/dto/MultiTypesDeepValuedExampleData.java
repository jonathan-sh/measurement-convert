package io.jonathan.converter.dto;

import io.jonathan.converter.MeasurementConvert;

import java.time.LocalDateTime;

import static io.jonathan.converter.Measurement.CELSIUS;
import static io.jonathan.converter.Measurement.FAHRENHEIT;


public class MultiTypesDeepValuedExampleData {
    @MeasurementConvert(current = CELSIUS, metric = CELSIUS, imperial = FAHRENHEIT)
    public String temperature;

    public LocalDateTime now;

    public ClassMetricExampleData classMetricExampleData;
    public RecordMetricExampleData recordMetricExampleData;

    public InternalClass internalClass;
    public InternalRecord internalRecord;

    public MultiTypesDeepValuedExampleData(String temperature,
                                           LocalDateTime now,
                                           ClassMetricExampleData classMetricExampleData,
                                           RecordMetricExampleData recordMetricExampleData,
                                           InternalClass internalClass, InternalRecord internalRecord) {
        this.temperature = temperature;
        this.now = now;
        this.classMetricExampleData = classMetricExampleData;
        this.recordMetricExampleData = recordMetricExampleData;
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
