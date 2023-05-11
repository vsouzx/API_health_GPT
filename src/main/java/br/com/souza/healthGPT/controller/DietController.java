package br.com.souza.healthGPT.controller;

import br.com.souza.healthGPT.dto.InformationsRequest;
import br.com.souza.healthGPT.service.DietService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class DietController {

    private final DietService service;

    public DietController(DietService service) {
        this.service = service;
    }

    @PostMapping(value = "/diet")
    public ResponseEntity<String> getDiet(@RequestBody InformationsRequest request){
        return new ResponseEntity<>(service.generate(request), HttpStatus.OK);
    }
}
