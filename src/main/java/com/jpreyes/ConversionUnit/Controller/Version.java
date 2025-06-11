package com.jpreyes.ConversionUnit.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/")
public class Version {
    @GetMapping("version")
    public Map<String, String> getVersion(){
        Map<String, String> getVersion = Map.of(
                "Status","ONLINE",
                "Versión","1.0"
        );
        return getVersion;
    }
}
