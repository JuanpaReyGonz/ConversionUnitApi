package com.jpreyes.ConversionUnit.Service;

import com.jpreyes.ConversionUnit.Conversion.ConversionRequest;
import com.jpreyes.ConversionUnit.Conversion.ConversionResponse;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class ConversionServiceTest {
    private final ConversionService conversionService = new ConversionService();

    @Test
    void convert_centigradesToKelvinAndFarenheit(){
        ConversionRequest request = new ConversionRequest();
        request.setValue(10);
        request.setUnitType('C');
        List<ConversionResponse> actual = conversionService.conversion(request);
        List<ConversionResponse> expected = List.of(
                ConversionResponse.builder()
                        .value(283.15)
                        .unitType('K')
                        .build(),
                ConversionResponse.builder()
                        .value(50.0)
                        .unitType('F')
                        .build()
        );
        assertIterableEquals(expected, actual);
    }

    @Test
    void convert_kelvinToCentigradesAndFarenheit(){
        ConversionRequest request = new ConversionRequest();
        request.setValue(568);
        request.setUnitType('K');
        List<ConversionResponse> actual = conversionService.conversion(request);
        List<ConversionResponse> expected = List.of(
                ConversionResponse.builder()
                        .value(294.85)
                        .unitType('C')
                        .build(),
                ConversionResponse.builder()
                        .value(562.73)
                        .unitType('F')
                        .build()
        );
        assertIterableEquals(expected, actual);
    }

    @Test
    void convert_farenheitToCentigradesAndKelvin(){
        ConversionRequest request = new ConversionRequest();
        request.setValue(32);
        request.setUnitType('F');
        List<ConversionResponse> actual = conversionService.conversion(request);
        List<ConversionResponse> expected = List.of(
                ConversionResponse.builder()
                        .value(0.0)
                        .unitType('C')
                        .build(),
                ConversionResponse.builder()
                        .value(273.15)
                        .unitType('K')
                        .build()
        );
        assertIterableEquals(expected, actual);
    }

}
