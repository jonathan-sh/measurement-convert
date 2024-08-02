## Adding a New Conversion Function:

To introduce a new conversion function, follow these steps:

1. Develop a new implementation using the `ConvertFunction` interface.
2. Incorporate your implementation into the `CONVERTER_FUNCTION_MAP` using the `pushConvertFunction` function within
   the `Processor` file.

Once these steps are completed, simply utilize the `@MeasurementConvert` annotation to map your Data Transfer Object (
DTO).

Additionally, please remember to invoke either `RestHandler.applyMeasurementInternationalization()` at the REST layer
or `MeasurementConverter.applyUserSystem()` within your service.