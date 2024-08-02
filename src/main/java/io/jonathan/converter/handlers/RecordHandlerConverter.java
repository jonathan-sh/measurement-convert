package io.jonathan.converter.handlers;


import io.jonathan.converter.MeasurementConvert;
import io.jonathan.converter.MeasurementConverter;
import io.jonathan.converter.SystemType;
import io.jonathan.converter.functions.Processor;

import java.lang.reflect.RecordComponent;
import java.util.List;
import java.util.Optional;

public class RecordHandlerConverter {


    public static <T> Optional<T> apply(T item, SystemType systemType) {
        try {
            var entity = item.getClass();
            var components = entity.getRecordComponents();
            Object[] args = new Object[entity.getRecordComponents().length];
            Class<?>[] types = new Class<?>[entity.getRecordComponents().length];

            int index = -1;

            for (RecordComponent component : components) {
                index++;

                var field = entity.getDeclaredField(component.getAccessor().getName());
                types[index] = field.getType();
                var value = component.getAccessor().invoke(item);

                if (value == null) {
                    args[index] = null;
                    continue;
                }

                var fieldType = field.getType();

                if (fieldType == List.class) {
                    var list = (List<Object>) value;
                    var converted = list.stream().map(it -> MeasurementConverter.applySystem(it, systemType).get()).toList();
                    args[index] = converted;
                    continue;
                }

                if (Processor.requireReflection(fieldType)) {
                    args[index] = MeasurementConverter.applySystem(value, systemType).orElse(value);
                    continue;
                }

                if (!Processor.isString(fieldType)) {
                    args[index] = value;
                    continue;
                }

                if (!field.isAnnotationPresent(MeasurementConvert.class)) {
                    args[index] = value;
                    continue;
                }

                args[index] = Processor.getConvertValue(field, value, systemType, item.getClass());
            }

            return Optional.of((T) entity.getConstructor(types).newInstance(args));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return Optional.of(item);
    }
}