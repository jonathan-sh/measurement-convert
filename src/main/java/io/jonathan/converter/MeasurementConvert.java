package io.jonathan.converter;


import io.jonathan.converter.functions.MeasurementConvertProcessor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
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
    String formatter() default MeasurementConvertProcessor.DECIMAL;
}
