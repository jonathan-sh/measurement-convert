package io.jonathan.converter.functions;


import io.jonathan.converter.MeasurementConvert;
import io.jonathan.converter.SystemType;
import io.jonathan.converter.functions.impl.CelsiusFahrenheit;
import io.jonathan.converter.functions.impl.CentimeterFoots;
import io.jonathan.converter.functions.impl.CentimeterInches;
import io.jonathan.converter.functions.impl.HectaresAcres;
import io.jonathan.converter.functions.impl.KilometerHourMilesHour;
import io.jonathan.converter.functions.impl.LiterGallon;
import io.jonathan.converter.functions.impl.LiterHectaresGallonAcres;
import io.jonathan.converter.functions.impl.MillimeterInches;
import io.jonathan.converter.functions.impl.PascalPoundsPerSquareInch;
import io.jonathan.converter.functions.impl.SquareCentimeterSquareFoots;
import io.jonathan.converter.functions.impl.SquareCentimeterSquareInches;
import io.jonathan.converter.functions.impl.SquareMeterAcres;
import io.jonathan.converter.functions.impl.SquareMeterHectares;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

public class Processor {

    public static final Map<String, Function<Double, Double>> CONVERTER_FUNCTION_MAP = new HashMap<>();
    public static final List<Class<?>> NOT_ALLOW_PERFORM_REFLECTION = List.of(String.class, Integer.class, Long.class,
            Boolean.class, LocalDateTime.class, LocalDate.class, Object.class, Double.class, List.class, Map.class, HashMap.class);
    public static final String INTEIRO = "#";
    public static final String DECIMAL = "#.##";
    private static final List<String> LIST_KEYS = List.of("arraylist", "immutablecollections");

    static {

        pushConvertFunction(new CelsiusFahrenheit());
        pushConvertFunction(new CentimeterFoots());
        pushConvertFunction(new CentimeterInches());
        pushConvertFunction(new HectaresAcres());
        pushConvertFunction(new KilometerHourMilesHour());
        pushConvertFunction(new LiterGallon());
        pushConvertFunction(new LiterHectaresGallonAcres());
        pushConvertFunction(new MillimeterInches());
        pushConvertFunction(new SquareCentimeterSquareFoots());
        pushConvertFunction(new SquareCentimeterSquareInches());
        pushConvertFunction(new SquareMeterAcres());
        pushConvertFunction(new SquareMeterHectares());
        pushConvertFunction(new PascalPoundsPerSquareInch());
    }

    public static Boolean isString(Class clazz) {
        return clazz.equals(String.class);
    }

    public static Boolean requireReflection(Class clazz) {
        return !NOT_ALLOW_PERFORM_REFLECTION.contains(clazz);
    }

    private static void pushConvertFunction(ConvertFunction convertFunction) {
        var keyToApply = convertFunction.from() + "_" + convertFunction.to();
        var keyToReverse = convertFunction.to() + "_" + convertFunction.from();
        CONVERTER_FUNCTION_MAP.put(keyToApply, convertFunction::apply);
        CONVERTER_FUNCTION_MAP.put(keyToReverse, convertFunction::reverse);
    }


    public static String getConvertValue(Field field, Object value, SystemType systemType, Class<?> originClass) {
        MeasurementConvert config = field.getAnnotation(MeasurementConvert.class);
        var from = config.current();
        var to = config.metric();
        if (systemType == SystemType.IMPERIAL) to = config.imperial();

        var formatterPatter = config.formatter();
        var doubleValue = 0.0;
        try {
            doubleValue = Double.parseDouble(value.toString());
        } catch (Exception e) {
            var file = originClass.getName() + "." + field.getName();
            throw new RuntimeException("The value [" + value + "] inside (" + file + ") " +
                    "is not a valid number string. Remove @MeasurementConvert or fix it.");
        }


        if (from == to) return getRound(doubleValue, systemType, formatterPatter) + to.symbol;

        var functionKey = from + "_" + to;
        if (!CONVERTER_FUNCTION_MAP.containsKey(functionKey)) {
            throw new RuntimeException("Convert function [" + functionKey + "] not implemented yet");
        }

        var newValue = CONVERTER_FUNCTION_MAP.get(functionKey).apply(doubleValue);
        return getRound(newValue, systemType, formatterPatter) + to.symbol;
    }

    public static String getRound(double numericValue, SystemType systemType, String formatterPatter) {
        int i = Double.valueOf(numericValue).intValue();

        var result = "";

        if (Objects.equals(formatterPatter, INTEIRO)) {
            result = String.valueOf(i);
        } else {

            String stringDecimal = String.valueOf(numericValue).split("\\.")[1];
            stringDecimal = stringDecimal.substring(0, Math.min(2, stringDecimal.length()));
            char[] charArrayDecimal = stringDecimal.toCharArray();

            int sun = 0;
            for (char c : charArrayDecimal) sun += Integer.parseInt(String.valueOf(c));

            if (sun == 0) {
                result = String.valueOf(i);
            } else if (charArrayDecimal.length > 1 && stringDecimal.toCharArray()[1] == '0') {
                result = i + "." + charArrayDecimal[0];
            } else {
                result = i + "." + stringDecimal;
            }
        }

        if (systemType == SystemType.METRIC) return result.replace(".", ",");
        return result;
    }

    public static <T> boolean isList(T item) {
        var baseName = item.getClass().getName().toLowerCase();
        return LIST_KEYS.stream().anyMatch(baseName::contains);
    }
}
