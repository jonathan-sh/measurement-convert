package io.jonathan.converter;

import io.jonathan.converter.dto.ClassImperial;
import io.jonathan.converter.dto.ClassMetric;
import io.jonathan.converter.dto.ClassMetricList;
import io.jonathan.converter.dto.ClassMetricMultiTypesDeepValued;
import io.jonathan.converter.dto.RecordImperial;
import io.jonathan.converter.dto.RecordMetric;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

public class ConverterTest {

    @Test
    @DisplayName("Record with metric input")
    public void recordWithMetricInput() {
        var toConvert = new RecordMetric("38", LocalDateTime.now());

        var imperial = MeasurementConverter.applyImperialSystem(toConvert);
        Assertions.assertTrue(imperial.isPresent());
        Assertions.assertEquals("100.4ºF", imperial.get().temperature());

        var metric = MeasurementConverter.applyMetricSystem(toConvert);
        Assertions.assertTrue(metric.isPresent());
        Assertions.assertEquals("38ºC", metric.get().temperature());
    }

    @Test
    @DisplayName("Record with imperial input")
    public void recordWithImperialInput() {
        var toConvert = new RecordImperial("100", LocalDateTime.now());

        var imperial = MeasurementConverter.applyImperialSystem(toConvert);
        Assertions.assertTrue(imperial.isPresent());
        Assertions.assertEquals("100ºF", imperial.get().temperature());

        var metric = MeasurementConverter.applyMetricSystem(toConvert);
        Assertions.assertTrue(metric.isPresent());
        Assertions.assertEquals("37,77ºC", metric.get().temperature());
    }

    @Test
    @DisplayName("Class with metric input")
    public void classWithMetricInput() {
        var toConvert = new ClassMetric("37", LocalDateTime.now());

        var imperial = MeasurementConverter.applyImperialSystem(toConvert);
        Assertions.assertTrue(imperial.isPresent());
        Assertions.assertEquals("98.6ºF", imperial.get().temperature);

        toConvert.temperature = "38";
        var metric = MeasurementConverter.applyMetricSystem(toConvert);
        Assertions.assertTrue(metric.isPresent());
        Assertions.assertEquals("38ºC", metric.get().temperature);
    }

    @Test
    @DisplayName("Class with imperial input")
    public void classWithImperialInput() {
        var toConvert = new ClassImperial("100", LocalDateTime.now());

        var imperial = MeasurementConverter.applyImperialSystem(toConvert);
        Assertions.assertTrue(imperial.isPresent());
        Assertions.assertEquals("100ºF", imperial.get().temperature);

        toConvert.temperature = "100";
        var metric = MeasurementConverter.applyMetricSystem(toConvert);
        Assertions.assertTrue(metric.isPresent());
        Assertions.assertEquals("37,77ºC", metric.get().temperature);
    }

    @Test
    @DisplayName("Class with double input")
    public void classWithDoubleInput() {
        var toConvert = new ClassMetricList(38.00, LocalDateTime.now());
        var imperial = MeasurementConverter.applyImperialSystem(toConvert);
        Assertions.assertTrue(imperial.isPresent());
        Assertions.assertEquals(100.4, imperial.get().temperature);
    }

    @Test
    @DisplayName("Class with a list of double input")
    public void classWithListDoubleInput() {
        var toConvert = new ClassMetricList(38.00, LocalDateTime.now());
        toConvert.temperatureList = List.of(38.00, 38.00, 38.00);
        var imperial = MeasurementConverter.applyImperialSystem(toConvert);
        Assertions.assertTrue(imperial.isPresent());
        Assertions.assertEquals(100.4, imperial.get().temperature);
        Assertions.assertEquals(100.4, imperial.get().temperatureList.get(0));
        Assertions.assertEquals(100.4, imperial.get().temperatureList.get(1));
        Assertions.assertEquals(100.4, imperial.get().temperatureList.get(2));
    }

    @Test
    @DisplayName("Class with a list of string input")
    public void classWithListStringInput() {
        var toConvert = new ClassMetricList(38.00, LocalDateTime.now());
        toConvert.temperatureList = List.of(38.00, 38.00, 38.00);
        toConvert.temperatureListString = List.of("38.00", "38.00", "38.00");
        var imperial = MeasurementConverter.applyImperialSystem(toConvert);
        Assertions.assertTrue(imperial.isPresent());
        Assertions.assertEquals(100.4, imperial.get().temperature);
        Assertions.assertEquals(100.4, imperial.get().temperatureList.get(0));
        Assertions.assertEquals(100.4, imperial.get().temperatureList.get(1));
        Assertions.assertEquals(100.4, imperial.get().temperatureList.get(2));
        Assertions.assertEquals("100.4ºF", imperial.get().temperatureListString.get(0));
        Assertions.assertEquals("100.4ºF", imperial.get().temperatureListString.get(1));
        Assertions.assertEquals("100.4ºF", imperial.get().temperatureListString.get(2));
    }


    @Test
    @DisplayName("Class with a list of object input")
    public void classWithListObjectInput() {
        var toConvert = new ClassMetricList(38.00, LocalDateTime.now());
        toConvert.temperatureList = List.of(38.00, 38.00, 38.00);
        toConvert.temperatureListString = List.of("38.00", "38.00", "38.00");
        toConvert.temperatureListObject = List.of(
                new ClassMetric("38", LocalDateTime.now()),
                new ClassMetric("38", LocalDateTime.now()),
                new ClassMetric("38", LocalDateTime.now()));
        var imperial = MeasurementConverter.applyImperialSystem(toConvert);
        Assertions.assertTrue(imperial.isPresent());
        Assertions.assertEquals(100.4, imperial.get().temperature);
        Assertions.assertEquals(100.4, imperial.get().temperatureList.get(0));
        Assertions.assertEquals(100.4, imperial.get().temperatureList.get(1));
        Assertions.assertEquals(100.4, imperial.get().temperatureList.get(2));
        Assertions.assertEquals("100.4ºF", imperial.get().temperatureListString.get(0));
        Assertions.assertEquals("100.4ºF", imperial.get().temperatureListString.get(1));
        Assertions.assertEquals("100.4ºF", imperial.get().temperatureListString.get(2));
        Assertions.assertEquals("100.4ºF", imperial.get().temperatureListObject.get(0).temperature);
        Assertions.assertEquals("100.4ºF", imperial.get().temperatureListObject.get(1).temperature);
        Assertions.assertEquals("100.4ºF", imperial.get().temperatureListObject.get(2).temperature);
    }

    @Test
    @DisplayName("Multi types deep valued")
    public void multiTypesDeepValuedExampleData() {
        var now = LocalDateTime.now();
        var clazz = new ClassMetric("38", now);
        var record = new RecordMetric("38", now);
        var internalClass = new ClassMetricMultiTypesDeepValued.InternalClass("38", now);
        var internalRecord = new ClassMetricMultiTypesDeepValued.InternalRecord("38", now);
        var multi = new ClassMetricMultiTypesDeepValued("38", now, clazz, record, internalClass, internalRecord);

        multi.temperatureInDouble = 38.00;
        multi.temperatureInString = "38.00";
        multi.temperatureInStringList = List.of("38.00", "38.00");
        multi.temperatureInDoubleList = List.of(38.00, 38.00);

        var imperial = MeasurementConverter.applyImperialSystem(multi);

        Assertions.assertTrue(imperial.isPresent());

        var result = imperial.get();

        //string list
        Assertions.assertEquals("100.4ºF", result.temperatureInString);
        Assertions.assertEquals("100.4ºF", result.temperatureInStringList.get(0));
        Assertions.assertEquals("100.4ºF", result.temperatureInStringList.get(1));

        //double list
        Assertions.assertEquals(100.4, result.temperatureInDouble);
        Assertions.assertEquals(100.4, result.temperatureInDoubleList.get(0));
        Assertions.assertEquals(100.4, result.temperatureInDoubleList.get(1));

        //class and record
        Assertions.assertEquals("100.4ºF", result.classMetric.temperature);
        Assertions.assertEquals("100.4ºF", result.recordMetric.temperature());

        //internal class and record
        Assertions.assertEquals("100.4ºF", result.internalClass.temperature);
        Assertions.assertEquals("100.4ºF", result.internalRecord.temperature());

        //checking not converted values
        Assertions.assertEquals(now, result.now);
        Assertions.assertEquals(now, result.classMetric.now);
        Assertions.assertEquals(now, result.recordMetric.now());
        Assertions.assertEquals(now, result.internalClass.now);
        Assertions.assertEquals(now, result.internalRecord.now());
    }
}
