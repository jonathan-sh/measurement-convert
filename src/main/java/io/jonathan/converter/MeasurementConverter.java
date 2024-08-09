package io.jonathan.converter;


import io.jonathan.converter.handlers.ClassHandlerConverter;
import io.jonathan.converter.handlers.RecordHandlerConverter;
import org.jboss.logging.Logger;

import java.util.Optional;

//todo remove that shit duplications
public class MeasurementConverter {
    private static final Logger logger = Logger.getLogger(MeasurementConverter.class);

    public static <T> Optional<T> applySystem(T item, SystemType systemType) {
        if (item == null) {
            logger.error("Null object was provided");
            return Optional.empty();
        }
        if (item.getClass().isRecord()) return RecordHandlerConverter.apply(item, systemType);
        return ClassHandlerConverter.applySystem(item, systemType);
    }

    public static <T> Optional<T> applyImperialSystem(T item) {
        if (item == null) {
            logger.error("Null object was provided");
            return Optional.empty();
        }
        if (item.getClass().isRecord()) return RecordHandlerConverter.apply(item, SystemType.IMPERIAL);
        return ClassHandlerConverter.applySystem(item, SystemType.IMPERIAL);
    }

    public static <T> Optional<T> applyMetricSystem(T item) {
        if (item == null) {
            logger.error("Null object was provided");
            return Optional.empty();
        }
        if (item.getClass().isRecord()) return RecordHandlerConverter.apply(item, SystemType.METRIC);
        return ClassHandlerConverter.applySystem(item, SystemType.METRIC);

    }
}
