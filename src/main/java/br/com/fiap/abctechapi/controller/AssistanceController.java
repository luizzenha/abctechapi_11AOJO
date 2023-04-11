package br.com.fiap.abctechapi.controller;


import br.com.fiap.abctechapi.application.AssistanceApplication;
import br.com.fiap.abctechapi.application.dto.AssistResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RequestMapping("/assists")
@RestController
public class AssistanceController {


    private final AssistanceApplication assistanceApplication;

    @Autowired
    public AssistanceController(AssistanceApplication assistanceApplication){
        this.assistanceApplication = assistanceApplication;
    }

    @GetMapping
    public ResponseEntity<List<AssistResponseDto>> getAssists(){
        return ResponseEntity.ok(assistanceApplication.getAssists());
    }

}
