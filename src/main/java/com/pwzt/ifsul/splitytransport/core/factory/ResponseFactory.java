package com.pwzt.ifsul.splitytransport.core.factory;

import com.pwzt.ifsul.splitytransport.api.dto.response.ResponseApi;
import com.pwzt.ifsul.splitytransport.api.dto.response.ResponseMensagem;
import com.pwzt.ifsul.splitytransport.api.dto.response.cadastro.ResponseCadastroBaseAntt;
import com.pwzt.ifsul.splitytransport.api.dto.response.cadastro.ResponseCadastroMotoristaAntt;
import com.pwzt.ifsul.splitytransport.api.dto.response.cte.ResponseCTe;
import com.pwzt.ifsul.splitytransport.api.dto.response.cte.ResponseCTeEmissao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ResponseFactory {

    public static ResponseApi createResponseCadastroVeiculo(ResponseCadastroBaseAntt responseMock, String http){
        ResponseApi response = new ResponseApi();

        ResponseMensagem mensagem = new ResponseMensagem.Builder()
                .descricao(responseMock.getMotivoAntt())
                .codigo(responseMock.getCodigoStatusAntt())
                .tipoResolver(http)
                .build();

        response.setMotivo("Comunicação realizada com sucesso");
        response.setStatus(http);
        response.setTimestamp(LocalDateTime.now());
        response.addMensagem(mensagem);

        return response;
    }

    public static ResponseApi createResponseCadastroMotorista(ResponseCadastroMotoristaAntt responseMock, String httpStatu){
        ResponseApi response = new ResponseApi();

        ResponseMensagem mensagem = new ResponseMensagem.Builder()
                .descricao(String.format("%s. Rntrc cadastrado: %s", responseMock.getMotivoAntt(), responseMock.getRntrc()))
                .codigo(responseMock.getCodigoStatusAntt())
                .tipoResolver(httpStatu)
                .build();

        response.setMotivo("Comunicação realizada com sucesso");
        response.setStatus(httpStatu);
        response.setTimestamp(LocalDateTime.now());
        response.addMensagem(mensagem);

        return response;
    }

    public static ResponseApi createResponseSucesso(String status, String motivo){
        ResponseApi response = new ResponseApi();

        response.setTimestamp(LocalDateTime.now());
        response.setMotivo(motivo);
        response.setStatus(status);

        return response;
    }

    public static ResponseCTeEmissao emissaoCTeSucesso(String chaveCte){
        ResponseCTeEmissao response = new ResponseCTeEmissao();
        List<ResponseMensagem> messageList = new ArrayList<>();

        ResponseMensagem mensagem = new ResponseMensagem.Builder()
                .descricao("CTe emitido com sucesso")
                .codigo("205")
                .sucesso()
                .build();

        messageList.add(mensagem);

        response.setDataAutorizacao(LocalDateTime.now());
        response.setMotivo("Comunicação com Sefaz realizada com sucesso");
        response.setMensagemList(messageList);
        response.setChaveCte(chaveCte);
        response.setStatus("200");

        return response;
    }

}
