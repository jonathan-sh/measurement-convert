## About

Provides a simple way to make measurement conversions between METRIC and IMPERIAL systems.
> A special thanks to @lat94 for the support :).

## Install

```xml

<dependency>
    <groupId>io.jonathan</groupId>
    <artifactId>measurement-convert</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

## Using

Adding the annotations to my object

```java
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
```

Applying the systems

```java
 public static void main(String[] args) {
    var input = new ExampleEntity(38.0, "38", "hey");

    //applying the metric system
    MeasurementConverter
            .applyMetricSystem(input)
            .ifPresent(metricOutput -> {
                System.out.println(metricOutput.temperatureNum());
                //38.0
                System.out.println(metricOutput.temperatureTxt());
                //38ºC
                System.out.println(metricOutput.notTouchValue());
                //hey
            });

    //applying the imperial system
    MeasurementConverter
            .applyImperialSystem(input)
            .ifPresent(imperialOutput -> {
                System.out.println(imperialOutput.temperatureNum());
                //100.4
                System.out.println(imperialOutput.temperatureTxt());
                //100.4ºF
                System.out.println(imperialOutput.notTouchValue());
                //hey
            });
}
```

## About the annotation

```java
public @interface MeasurementConvert {

    /**
     * The unit of measurement in which the object will be instantiated
     */
    Measurement current() default Measurement.NONE;


    /**
     * The desired unit of measurement when the metric system was applied
     */
    Measurement metric() default Measurement.NONE;


    /**
     * The desired unit of measurement when the imperial system was applied
     */
    Measurement imperial() default Measurement.NONE;


    /**
     * Controls the output format in DECIMAL(#.##) or INTEGER(#)
     */
    String formatter() default Processor.DECIMAL;
}
```

## Adding a New Conversion Function

To introduce a new conversion function, follow these steps:

1. Develop a new implementation using the `ConvertFunction` interface.
2. Incorporate your implementation into the `CONVERTER_FUNCTION_MAP` using the `pushConvertFunction` function within
   the `Processor` file.