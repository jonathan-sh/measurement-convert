package io.jonathan.converter.functions;

import io.jonathan.converter.SystemType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static io.jonathan.converter.SystemType.IMPERIAL;
import static io.jonathan.converter.SystemType.METRIC;
import static io.jonathan.converter.functions.Processor.DECIMAL;
import static io.jonathan.converter.functions.Processor.INTEIRO;
import static io.jonathan.converter.functions.Processor.isList;

class ProcessorTest {

    @Test
    @DisplayName("check round function")
    void getRound() {

        //METRIC
        var result = Processor.getRound(12.00, METRIC, DECIMAL);
        Assertions.assertEquals("12", result);

        result = Processor.getRound(12.00, METRIC, INTEIRO);
        Assertions.assertEquals("12", result);

        result = Processor.getRound(12.34, METRIC, DECIMAL);
        Assertions.assertEquals("12,34", result);

        result = Processor.getRound(12.34, METRIC, INTEIRO);
        Assertions.assertEquals("12", result);

        result = Processor.getRound(12.30, METRIC, DECIMAL);
        Assertions.assertEquals("12,3", result);

        result = Processor.getRound(12.30, METRIC, INTEIRO);
        Assertions.assertEquals("12", result);


        //IMPERIAL
        result = Processor.getRound(12.00, SystemType.IMPERIAL, DECIMAL);
        Assertions.assertEquals("12", result);

        result = Processor.getRound(12.00, IMPERIAL, INTEIRO);
        Assertions.assertEquals("12", result);

        result = Processor.getRound(12.34, IMPERIAL, DECIMAL);
        Assertions.assertEquals("12.34", result);

        result = Processor.getRound(12.34, IMPERIAL, INTEIRO);
        Assertions.assertEquals("12", result);

        result = Processor.getRound(12.30, IMPERIAL, DECIMAL);
        Assertions.assertEquals("12.3", result);

        result = Processor.getRound(12.30, IMPERIAL, INTEIRO);
        Assertions.assertEquals("12", result);

    }

    @Test
    @DisplayName("check isList function")
    void checkIsList() {
        Assertions.assertTrue(isList(List.of()));
        Assertions.assertTrue(isList(Set.of()));
        Assertions.assertTrue(isList(Map.of()));
    }
}