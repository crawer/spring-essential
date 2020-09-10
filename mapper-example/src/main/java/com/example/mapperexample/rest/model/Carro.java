package com.example.mapperexample.rest.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "carro")
@Data
public class Carro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String marca;
    private String ano;
    private String cor;
    private Double valor;

}
