package io.jonathan.converter;

import io.jonathan.converter.dto.ClassImperialExampleData;
import io.jonathan.converter.dto.ClassMetricExampleData;
import io.jonathan.converter.dto.MultiTypesDeepValuedExampleData;
import io.jonathan.converter.dto.RecordImperialExampleData;
import io.jonathan.converter.dto.RecordMetricExampleData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class ConverterTest {

    @Test
    @DisplayName("Record with metric input")
    public void recordWithMetricInput() {
        var toConvert = new RecordMetricExampleData("38", LocalDateTime.now());

        var imperial = MeasurementConverter.applyImperialSystem(toConvert);
        Assertions.assertTrue(imperial.isPresent());
        Assertions.assertEquals("100ºF", imperial.get().temperature());

        var metric = MeasurementConverter.applyMetricSystem(toConvert);
        Assertions.assertTrue(metric.isPresent());
        Assertions.assertEquals("38ºC", metric.get().temperature());
    }

    @Test
    @DisplayName("Record with imperial input")
    public void recordWithImperialInput() {
        var toConvert = new RecordImperialExampleData("100", LocalDateTime.now());

        var imperial = MeasurementConverter.applyImperialSystem(toConvert);
        Assertions.assertTrue(imperial.isPresent());
        Assertions.assertEquals("100ºF", imperial.get().temperature());

        var metric = MeasurementConverter.applyMetricSystem(toConvert);
        Assertions.assertTrue(metric.isPresent());
        Assertions.assertEquals("37ºC", metric.get().temperature());
    }

    @Test
    @DisplayName("Class with metric input")
    public void classWithMetricInput() {
        var toConvert = new ClassMetricExampleData("37", LocalDateTime.now());

        var imperial = MeasurementConverter.applyImperialSystem(toConvert);
        Assertions.assertTrue(imperial.isPresent());
        Assertions.assertEquals("98ºF", imperial.get().temperature);

        toConvert.temperature = "38";
        var metric = MeasurementConverter.applyMetricSystem(toConvert);
        Assertions.assertTrue(metric.isPresent());
        Assertions.assertEquals("38ºC", metric.get().temperature);
    }

    @Test
    @DisplayName("Class with imperial input")
    public void classWithImperialInput() {
        var toConvert = new ClassImperialExampleData("100", LocalDateTime.now());

        var imperial = MeasurementConverter.applyImperialSystem(toConvert);
        Assertions.assertTrue(imperial.isPresent());
        Assertions.assertEquals("100ºF", imperial.get().temperature);

        toConvert.temperature = "100";
        var metric = MeasurementConverter.applyMetricSystem(toConvert);
        Assertions.assertTrue(metric.isPresent());
        Assertions.assertEquals("37ºC", metric.get().temperature);
    }

    @Test
    @DisplayName("Multi types Deep valued")
    public void multiTypesDeepValuedExampleData() {
        var now = LocalDateTime.now();
        var clazz = new ClassMetricExampleData("38", now);
        var record = new RecordMetricExampleData("38", now);
        var internalClass = new MultiTypesDeepValuedExampleData.InternalClass("38", now);
        var internalRecord = new MultiTypesDeepValuedExampleData.InternalRecord("38", now);
        var multi = new MultiTypesDeepValuedExampleData("38", now, clazz, record, internalClass, internalRecord);

        var imperial = MeasurementConverter.applyImperialSystem(multi);

        Assertions.assertTrue(imperial.isPresent());

        var result = imperial.get();

        Assertions.assertEquals("100ºF", result.temperature);
        Assertions.assertEquals("100ºF", result.classMetricExampleData.temperature);
        Assertions.assertEquals("100ºF", result.recordMetricExampleData.temperature());
        Assertions.assertEquals("100ºF", result.internalClass.temperature);
        Assertions.assertEquals("100ºF", result.internalRecord.temperature());

        Assertions.assertEquals(now, result.now);
        Assertions.assertEquals(now, result.classMetricExampleData.now);
        Assertions.assertEquals(now, result.recordMetricExampleData.now());
        Assertions.assertEquals(now, result.internalClass.now);
        Assertions.assertEquals(now, result.internalRecord.now());
    }
}
