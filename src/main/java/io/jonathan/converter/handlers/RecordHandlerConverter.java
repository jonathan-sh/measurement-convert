package io.jonathan.converter.handlers;


import io.jonathan.converter.MeasurementConverter;
import io.jonathan.converter.SystemType;
import org.jboss.logging.Logger;

import java.lang.reflect.RecordComponent;
import java.util.Optional;

import static io.jonathan.converter.handlers.UtilHandler.allowToPerformConversion;
import static io.jonathan.converter.handlers.UtilHandler.convertList;
import static io.jonathan.converter.handlers.UtilHandler.convertSingle;
import static io.jonathan.converter.handlers.UtilHandler.isList;
import static io.jonathan.converter.handlers.UtilHandler.isNotMeasurementConvertItem;

public class RecordHandlerConverter {
    private static final Logger logger = Logger.getLogger(ClassHandlerConverter.class);

    @SuppressWarnings("unchecked")
    public static <T> Optional<T> apply(T father, SystemType systemType) {
        try {
            var entity = father.getClass();
            var components = entity.getRecordComponents();
            Object[] args = new Object[entity.getRecordComponents().length];
            Class<?>[] types = new Class<?>[entity.getRecordComponents().length];

            int index = -1;

            for (RecordComponent component : components) {
                index++;

                var field = entity.getDeclaredField(component.getAccessor().getName());
                types[index] = field.getType();
                var value = component.getAccessor().invoke(father);

                if (value == null || isNotMeasurementConvertItem(field)) {
                    args[index] = value;
                    continue;
                }

                if (allowToPerformConversion(field)) {
                    var newValue = convertSingle(field, value, systemType, father);
                    args[index] = newValue;
                    continue;
                }

                if (isList(field)) {
                    var newValue = convertList(field, value, systemType, father);
                    args[index] = newValue;
                    continue;
                }

                var newValue = MeasurementConverter.applySystem(value, systemType).orElse(value);
                args[index] = newValue;
            }
            return Optional.of((T) entity.getConstructor(types).newInstance(args));
        } catch (Exception e) {
            logger.error(e.getMessage());
            return Optional.empty();
        }
    }
}