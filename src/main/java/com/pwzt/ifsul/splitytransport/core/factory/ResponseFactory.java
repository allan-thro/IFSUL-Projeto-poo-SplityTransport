package com.pwzt.ifsul.splitytransport.core.factory;

import com.pwzt.ifsul.splitytransport.api.dto.response.ResponseApi;
import com.pwzt.ifsul.splitytransport.api.dto.response.ResponseMensagem;
import com.pwzt.ifsul.splitytransport.api.dto.response.cadastro.ResponseCadastroBaseAntt;
import com.pwzt.ifsul.splitytransport.api.dto.response.cte.ResponseCTeEmissao;

import java.time.LocalDateTime;

public class ResponseFactory {

    public static ResponseApi createResponseCadastroAntt(ResponseCadastroBaseAntt responseMock, String http){
        ResponseApi response = new ResponseApi();

        ResponseMensagem mensagem = new ResponseMensagem.Builder()
                .descricao(responseMock.getMotivoAntt())
                .codigo(response.getStatus())
                .tipoResolver(response.getStatus())
                .build();

        response.setStatus(http);
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

        ResponseMensagem mensagem = new ResponseMensagem.Builder()
                .descricao("CTe emitido com sucesso")
                .codigo("205")
                .sucesso()
                .build();

        response.setDataAutorizacao(LocalDateTime.now());
        response.setMensagem(mensagem);
        response.setChaveCte(chaveCte);
        response.setStatus("200");

        return response;
    }

}
