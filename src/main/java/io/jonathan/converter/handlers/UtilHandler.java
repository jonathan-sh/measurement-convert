package io.jonathan.converter.handlers;

import io.jonathan.converter.MeasurementConvert;
import io.jonathan.converter.MeasurementConverter;
import io.jonathan.converter.SystemType;
import io.jonathan.converter.functions.MeasurementConvertProcessor;

import java.lang.reflect.Field;
import java.util.List;

public class UtilHandler {
    public static final List<Class<?>> ALLOW_PERFORM_CONVERSION = List.of(String.class, Double.class);
    private static final List<String> LIST_KEYS = List.of("arraylist", "immutablecollections", "list");

    @SuppressWarnings("unchecked")
    static <T> Object convertList(Field field, Object value, SystemType systemType, T father) {
        var list = (List<Object>) value;

        if (list.isEmpty()) return value;

        var firstElement = list.getFirst();

        if (allowToPerformConversion(firstElement)) {
            return list.stream()
                    .map(it -> MeasurementConvertProcessor.getConvertedFinalValue(field, it, systemType, father))
                    .toList();
        }

        return list.stream()
                .map(it -> MeasurementConverter.applySystem(it, systemType).get())
                .toList();
    }

    static <T> Object convertSingle(Field field, Object value, SystemType systemType, T father) {
        return MeasurementConvertProcessor.getConvertedFinalValue(field, value, systemType, father);
    }

    public static Boolean allowToPerformConversion(Field field) {
        return ALLOW_PERFORM_CONVERSION.contains(field.getType());
    }

    public static Boolean allowToPerformConversion(Object field) {
        return ALLOW_PERFORM_CONVERSION.contains(field.getClass());
    }

    public static boolean isList(Field item) {
        var baseName = item.getType().getName().toLowerCase();
        return LIST_KEYS.stream().anyMatch(baseName::contains);
    }

    public static boolean isNotMeasurementConvertItem(Field field) {
        return !field.isAnnotationPresent(MeasurementConvert.class);
    }
}
