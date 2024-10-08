package io.jonathan.converter.functions;

import io.jonathan.converter.SystemType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.jonathan.converter.SystemType.IMPERIAL;
import static io.jonathan.converter.SystemType.METRIC;
import static io.jonathan.converter.functions.MeasurementConvertProcessor.DECIMAL;
import static io.jonathan.converter.functions.MeasurementConvertProcessor.INTEGER;

class MeasurementConvertProcessorTest {

    @Test
    @DisplayName("check round function")
    void getRound() {

        //METRIC
        var result = MeasurementConvertProcessor.getRound(12.00, METRIC, DECIMAL);
        Assertions.assertEquals("12", result);

        result = MeasurementConvertProcessor.getRound(12.00, METRIC, INTEGER);
        Assertions.assertEquals("12", result);

        result = MeasurementConvertProcessor.getRound(12.34, METRIC, DECIMAL);
        Assertions.assertEquals("12,34", result);

        result = MeasurementConvertProcessor.getRound(12.34, METRIC, INTEGER);
        Assertions.assertEquals("12", result);

        result = MeasurementConvertProcessor.getRound(12.30, METRIC, DECIMAL);
        Assertions.assertEquals("12,3", result);

        result = MeasurementConvertProcessor.getRound(12.30, METRIC, INTEGER);
        Assertions.assertEquals("12", result);


        //IMPERIAL
        result = MeasurementConvertProcessor.getRound(12.00, SystemType.IMPERIAL, DECIMAL);
        Assertions.assertEquals("12", result);

        result = MeasurementConvertProcessor.getRound(12.00, IMPERIAL, INTEGER);
        Assertions.assertEquals("12", result);

        result = MeasurementConvertProcessor.getRound(12.34, IMPERIAL, DECIMAL);
        Assertions.assertEquals("12.34", result);

        result = MeasurementConvertProcessor.getRound(12.34, IMPERIAL, INTEGER);
        Assertions.assertEquals("12", result);

        result = MeasurementConvertProcessor.getRound(12.30, IMPERIAL, DECIMAL);
        Assertions.assertEquals("12.3", result);

        result = MeasurementConvertProcessor.getRound(12.30, IMPERIAL, INTEGER);
        Assertions.assertEquals("12", result);

    }
}