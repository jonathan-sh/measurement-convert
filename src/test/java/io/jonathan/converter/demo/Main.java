package io.jonathan.converter.demo;

import io.jonathan.converter.MeasurementConverter;

public class Main {
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
}
