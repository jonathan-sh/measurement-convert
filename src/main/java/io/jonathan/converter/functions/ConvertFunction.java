package io.jonathan.converter.functions;

import io.jonathan.converter.Measurement;

public interface ConvertFunction {

    Measurement from();

    Measurement to();

    Double apply(Double value);

    Double reverse(Double value);
}
