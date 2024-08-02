package io.jonathan.converter.handlers;


import io.jonathan.converter.MeasurementConvert;
import io.jonathan.converter.MeasurementConverter;
import io.jonathan.converter.SystemType;
import io.jonathan.converter.functions.Processor;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClassHandlerConverter {

    public static <T> Optional<T> applySystem(T item, SystemType systemType) {
        try {
            var fields = item.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                var value = field.get(item);

                if (value == null) continue;

                if (value.getClass() == ArrayList.class) {
                    //todo remove that validation and create a annotation to prevent ths list with Long, String types
                    var list = (List<Object>) value;
                    var converted = list.stream().map(it -> MeasurementConverter.applySystem(it, systemType).get()).toList();
                    field.set(item, converted);
                    continue;
                }

                var fieldType = field.getType();

                if (Processor.requireReflection(fieldType)) {
                    var newValue = MeasurementConverter.applySystem(value, systemType).orElse(value);
                    field.set(item, newValue);
                    continue;
                }

                if (!Processor.isString(fieldType)) continue;

                if (!field.isAnnotationPresent(MeasurementConvert.class)) continue;

                var newValue = Processor.getConvertValue(field, value, systemType, item.getClass());
                field.set(item, newValue);
            }

            return Optional.of(item);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Optional.of(item);
        }
    }
}