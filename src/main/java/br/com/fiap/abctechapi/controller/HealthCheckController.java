package br.com.fiap.abctechapi.controller;

import br.com.fiap.abctechapi.util.VersionComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@RestController
@RequestMapping("/")
public class HealthCheckController {

    private final VersionComponent versionComponent;

    public HealthCheckController(@Autowired VersionComponent versionComponent){
        this.versionComponent = versionComponent;
    }

    @GetMapping
    public ResponseEntity<String> status(){
        return ResponseEntity.ok("UP");
    }

    @GetMapping("version")
    public ResponseEntity<String> version(){
        return ResponseEntity.ok(this.versionComponent.getVersion());
    }

}
