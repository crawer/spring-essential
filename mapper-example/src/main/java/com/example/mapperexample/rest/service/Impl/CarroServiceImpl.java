package com.example.mapperexample.rest.service.Impl;

import com.example.mapperexample.repository.CarroRepository;
import com.example.mapperexample.rest.dto.CarroDto;
import com.example.mapperexample.rest.model.Carro;
import com.example.mapperexample.rest.service.CarroService;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class CarroServiceImpl implements CarroService {

    @Autowired
    private CarroRepository carroRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public void save(CarroDto carro) {
        Carro carro1 = convertToEntity(carro);
        Carro save = carroRepository.save(carro1);
        System.out.println(save);
    }

    @Override
    public List<CarroDto> buscaTodos(){
        List<Carro> carros = carroRepository.findAll();
        List<CarroDto> carroDtos = new ArrayList<>();
        for (Carro car : carros){
            carroDtos.add(convertToDto(car));
        }
        return carroDtos;
    }

    @Override
    public Optional<CarroDto> detalhe(Long id) {
        Optional<Carro> carDetalhe = carroRepository.findById(id);
        return carDetalhe.map(this::convertToDto);
    }

    @Override
    public void deleteById(Long id){
        carroRepository.deleteById(id);
    }

    private CarroDto convertToDto(Carro carro){
        CarroDto carroDto = modelMapper.map(carro, CarroDto.class);
        return carroDto;
    }

    private Carro convertToEntity(CarroDto carroDto){
        Carro carro = modelMapper.map(carroDto, Carro.class);
        return carro;
    }





}
