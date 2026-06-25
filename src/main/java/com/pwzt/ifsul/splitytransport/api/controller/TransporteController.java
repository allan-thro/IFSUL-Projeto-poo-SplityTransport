package com.pwzt.ifsul.splitytransport.api.controller;

import com.pwzt.ifsul.splitytransport.api.dto.response.ResponseApi;
import com.pwzt.ifsul.splitytransport.api.service.TransporteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("transporte")
@RestController

@AllArgsConstructor
public class TransporteController {

    private TransporteService transporteService;

    @PostMapping("/gerar")
    public ResponseEntity<ResponseApi> cadastrarTransporte(
            @RequestParam("cpf_motorista") String cpfMotorista,
            @RequestParam String placa
    ){
        ResponseApi resposta = transporteService.gerarTransporte(cpfMotorista, placa);
        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

    @PostMapping("/autorizar")
    public ResponseEntity<ResponseApi> autorizarTransporte(@RequestParam Long id){
        ResponseApi resposta = transporteService.autorizarTransporte(id);
        return ResponseEntity.status(HttpStatus.OK).body(resposta);
    }

    @PostMapping("/iniciar")
    public ResponseEntity<ResponseApi> iniciarTransporte(@RequestParam Long id){
        ResponseApi resposta = transporteService.iniciarTranporte(id);
        return ResponseEntity.status(HttpStatus.OK).body(resposta);
    }

    @PostMapping("/concluir")
    public ResponseEntity<ResponseApi> concluirTransporte(@RequestParam Long id){
        ResponseApi resposta = transporteService.concluirTransporte(id);
        return ResponseEntity.status(HttpStatus.OK).body(resposta);
    }

}
