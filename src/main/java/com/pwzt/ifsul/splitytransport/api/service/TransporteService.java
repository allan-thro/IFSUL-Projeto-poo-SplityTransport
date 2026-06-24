package com.pwzt.ifsul.splitytransport.api.service;

import com.pwzt.ifsul.splitytransport.api.dto.response.ResponseApi;
import com.pwzt.ifsul.splitytransport.api.dto.response.ResponseMensagem;
import com.pwzt.ifsul.splitytransport.api.repository.InjectionProvider;
import com.pwzt.ifsul.splitytransport.core.exception.TransporteValidationException;
import com.pwzt.ifsul.splitytransport.core.factory.ResponseFactory;
import com.pwzt.ifsul.splitytransport.core.factory.TransporteFactory;
import com.pwzt.ifsul.splitytransport.core.model.base.Transporte;
import com.pwzt.ifsul.splitytransport.core.validation.transporte.TransporteValidationHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service

public class TransporteService {

    @Qualifier("transporteValidationChain")
    private final TransporteValidationHandler validarionChain;

    ObjectMapper objectMapper = new ObjectMapper();

    public ResponseApi gerarTransporte(String cpf, String placa){
        Transporte transporte = TransporteFactory.createNovoTransporte(cpf, placa);
        InjectionProvider.getTransporteRepository().save(transporte);

        return ResponseFactory.createResponseSucesso("200", "Transporte cadastrado com sucesso, vincule um cte para iniciar a autorização");
    }

    public ResponseApi autorizarTransporte(Long id){
        Transporte transporte = InjectionProvider.getTransporteRepository().findById(id)
                .orElseThrow(() -> new TransporteValidationException("Não foi possivel encontrar o transporte para autoriza-lo"));


        List<ResponseMensagem> erroList = new ArrayList<>();
        validarionChain.handle(transporte, erroList);

        if(!erroList.isEmpty()) throw new TransporteValidationException("Erro nas validações, impossivel autorizar transporte", erroList);

        transporte.getTransporteStatus().autorizar();
        InjectionProvider.getTransporteRepository().save(transporte);

        return ResponseFactory.createResponseSucesso("200", String.format("Transporte %d autorizado com sucesso, aguardando inicio da viagem", id));
    }

    public ResponseApi iniciarTranporte(Long id){
        Transporte transporte = InjectionProvider.getTransporteRepository().findById(id)
                .orElseThrow(() -> new TransporteValidationException("Não foi possivel localizar o transporte para inicia-lo"));

        transporte.getTransporteStatus().iniciar();

        InjectionProvider.getTransporteRepository().save(transporte);

        return ResponseFactory.createResponseSucesso("200", String.format("Viagem iniciada com sucesso para transporte: %d, conclua a viajem ao chegar ao destino", id));
    }

    public ResponseApi concluirTransporte(Long id){
        Transporte transporte = InjectionProvider.getTransporteRepository().findById(id)
                .orElseThrow(() -> new TransporteValidationException("Não foi possivel localizar o transporte para conclui-lo"));

        transporte.getTransporteStatus().concluir();
        InjectionProvider.getTransporteRepository().save(transporte);

        return ResponseFactory.createResponseSucesso("200", String.format("Viagem concluida com sucesso para transporte: %d", id));
    }

}


