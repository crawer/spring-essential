package br.com.vicenticonsultacep.Consulta.CEP.restConsulta;

import br.com.vicenticonsultacep.Consulta.CEP.dao.ResponseCep;
import br.com.vicenticonsultacep.Consulta.CEP.model.Cep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/dados")
public class RestCep {

    @Autowired
    RestTemplate restTemplate;
    String URICep = "https://viacep.com.br/ws/";

    @GetMapping("/{cep}")
    public ResponseCep getCep(@PathVariable("cep") String cep){
        boolean b = cepValido(cep);
        ResponseCep dadosCep = new ResponseCep();
        if(!b)
            return null;
        dadosCep = restTemplate.getForObject(URICep + cep + "/json", ResponseCep.class);

        return dadosCep;

    }

    private boolean cepValido(String cep){
        return cep.length() == 8;
    }
}
