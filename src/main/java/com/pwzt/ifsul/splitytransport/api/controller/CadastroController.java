package com.pwzt.ifsul.splitytransport.api.controller;

import com.pwzt.ifsul.splitytransport.api.dto.request.cadastro.FilialDTO;
import com.pwzt.ifsul.splitytransport.api.dto.request.cadastro.MotoristaDTO;
import com.pwzt.ifsul.splitytransport.api.dto.request.cadastro.VeiculoDTO;
import com.pwzt.ifsul.splitytransport.api.dto.response.ResponseApi;
import com.pwzt.ifsul.splitytransport.api.service.CadastroService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/cadastro")
@RestController

@AllArgsConstructor
public class CadastroController {

    private CadastroService cadastroService;

    @PostMapping("/motorista")
    public ResponseEntity<ResponseApi> cadastrarMotorista(@RequestBody MotoristaDTO motoristaDTO){
        ResponseApi resposta = cadastroService.cadastrarMotorista(motoristaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

    @PostMapping("/filial")
    public ResponseEntity<ResponseApi> cadastrarFilial(@RequestBody FilialDTO filialDTO){
        ResponseApi resposta = cadastroService.cadastrarFilial(filialDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

    @PostMapping("/veiculo")
    public ResponseEntity<ResponseApi> cadastrarVeiculo(@RequestBody VeiculoDTO veiculoDTO){
        ResponseApi resposta = cadastroService.cadastrarVeiculo(veiculoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

}
