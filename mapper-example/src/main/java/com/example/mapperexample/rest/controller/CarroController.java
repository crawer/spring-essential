package com.example.mapperexample.rest.controller;

import com.example.mapperexample.rest.dto.CarroDto;
import com.example.mapperexample.rest.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/carro")
@RestController
public class CarroController {

    @Autowired
    private CarroService carroService;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody CarroDto carroDto){
        carroService.save(carroDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        List<CarroDto> carroDto = carroService.buscaTodos();
        return new ResponseEntity<>(carroDto, HttpStatus.OK);
    }

    @GetMapping("/detalhe")
    public ResponseEntity<?> detalhe(@RequestParam("id") Long id){
        Optional<CarroDto> detalhe = carroService.detalhe(id);
        return new ResponseEntity<>(detalhe, HttpStatus.FOUND);
    }

    @DeleteMapping
    public HttpStatus deleteItem(@RequestParam("id") Long id){
        carroService.deleteById(id);
        return HttpStatus.OK;
    }


}
