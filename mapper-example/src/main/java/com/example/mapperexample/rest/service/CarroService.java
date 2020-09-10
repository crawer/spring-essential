package com.example.mapperexample.rest.service;

import com.example.mapperexample.rest.dto.CarroDto;

import java.util.List;
import java.util.Optional;

public interface CarroService {

    void save(CarroDto carro);

    List<CarroDto> buscaTodos();

    Optional<CarroDto> detalhe(Long id);

    void deleteById(Long id);
}
