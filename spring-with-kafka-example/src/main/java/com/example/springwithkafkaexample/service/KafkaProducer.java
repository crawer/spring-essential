package com.example.springwithkafkaexample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    String kafkaTopic = "pedidos";

    public void send(String mensagem){
        kafkaTemplate.send(kafkaTopic, "POSTANDO INFORMAÇÃO NO TOPICO");
    }


}
