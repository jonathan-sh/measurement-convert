package io.jonathan.converter;


import io.jonathan.converter.functions.Processor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MeasurementConvert {
    Measurement current() default Measurement.NONE;

    Measurement metric() default Measurement.NONE;

    Measurement imperial() default Measurement.NONE;

    String formatter() default Processor.INTEIRO;
}
