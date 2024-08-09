package io.jonathan.converter.handlers;


import io.jonathan.converter.MeasurementConverter;
import io.jonathan.converter.SystemType;
import org.jboss.logging.Logger;

import java.lang.reflect.Field;
import java.util.Optional;

import static io.jonathan.converter.handlers.UtilHandler.allowToPerformConversion;
import static io.jonathan.converter.handlers.UtilHandler.convertList;
import static io.jonathan.converter.handlers.UtilHandler.convertSingle;
import static io.jonathan.converter.handlers.UtilHandler.isList;
import static io.jonathan.converter.handlers.UtilHandler.isNotMeasurementConvertItem;

public class ClassHandlerConverter {
    private static final Logger logger = Logger.getLogger(ClassHandlerConverter.class);

    public static <T> Optional<T> applySystem(T father, SystemType systemType) {
        try {
            var fields = father.getClass().getDeclaredFields();
            for (Field field : fields) {

                var value = field.get(father);

                if (value == null || isNotMeasurementConvertItem(field)) continue;

                if (allowToPerformConversion(field)) {
                    var newValue = convertSingle(field, value, systemType, father);
                    field.setAccessible(true);
                    field.set(father, newValue);
                    continue;
                }

                if (isList(field)) {
                    var newValue = convertList(field, value, systemType, father);
                    field.setAccessible(true);
                    field.set(father, newValue);
                    continue;
                }

                var newValue = MeasurementConverter.applySystem(value, systemType).orElse(value);
                field.setAccessible(true);
                field.set(father, newValue);
            }

            return Optional.of(father);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return Optional.empty();
        }
    }
}