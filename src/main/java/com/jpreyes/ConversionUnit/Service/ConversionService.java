package com.jpreyes.ConversionUnit.Service;

import com.jpreyes.ConversionUnit.Conversion.ConversionRequest;
import com.jpreyes.ConversionUnit.Conversion.ConversionResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConversionService {
    public List<ConversionResponse> conversion(ConversionRequest request){
        double value = request.getValue();
        char unitType= Character.toUpperCase(request.getUnitType());

        switch (unitType){
            case 'C':
                return List.of(
                        ConversionResponse.builder()
                                .value(value + 273.15)
                                .unitType('K')
                                .build(),
                        ConversionResponse.builder()
                                .value((value * 9/5) + 32)
                                .unitType('F')
                                .build()
                );
            case 'K':
                return List.of(
                        ConversionResponse.builder()
                                .value(value - 273.15)
                                .unitType('C')
                                .build(),
                        ConversionResponse.builder()
                                .value( (value - 273.15) * 9/5 + 32)
                                .unitType('F')
                                .build()
                );
            case 'F':
                return List.of(
                        ConversionResponse.builder()
                                .value((value - 32) * 5/9)
                                .unitType('C')
                                .build(),
                        ConversionResponse.builder()
                                .value( (value - 32) * 5/9 + 273.15)
                                .unitType('K')
                                .build()
                );
        }
        return null;
    }
}
