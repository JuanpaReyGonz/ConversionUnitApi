package com.jpreyes.ConversionUnit.Controller;

import com.jpreyes.ConversionUnit.Conversion.ConversionRequest;
import com.jpreyes.ConversionUnit.Service.ConversionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/conversion/")
@RequiredArgsConstructor
public class ConversionController {
    private final ConversionService conversionService;
    @PostMapping(value = "temperature")
    public ResponseEntity<?> convertTemperature(@RequestBody ConversionRequest request) {
        return ResponseEntity.ok(conversionService.conversion(request));
    }
}
