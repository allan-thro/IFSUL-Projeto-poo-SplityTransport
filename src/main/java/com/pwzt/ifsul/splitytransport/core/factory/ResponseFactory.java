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

    public static ResponseApi cadastroSucesso(String status, String motivo){
        ResponseApi response = new ResponseApi();

        response.setTimestamp(LocalDateTime.now());
        response.setMotivo(motivo);
        response.setStatus(status);

        return response;
    }

    /*public static ResponseApi createCadastroMotoristaAntt(ResponseCadastroMotoristaAntt response){
        ArrayList<Mensagem> mensagemRetorno = new ArrayList<>();

        Mensagem mensagemMock = new Mensagem(response.getCodigoStatusAntt(), response.getMotivoAntt());
        mensagemRetorno.add(mensagemMock);

        return new ResponseApi("200", null, LocalDateTime.now(), mensagemRetorno);
    }

    public static ResponseApi createCadastroVeiculoAntt(ResponseCadastroVeiculoAntt response){
        ArrayList<Mensagem>
    }*/

    public static ResponseCTeEmissao emissaoCTeSucesso(String chaveCte){
        ResponseCTeEmissao responseEmissao = new ResponseCTeEmissao();



        /*Mensagem mensagem = new Mensagem("105", "CTe enviada para a fila de emissão, consulte pela chave para obter detalhes do processamento");
        mensagemRetorno.add(mensagem);

        responseEmissao.setDataEmissao(LocalDateTime.now());
        responseEmissao.setMensagemList(mensagemRetorno);
        responseEmissao.setChaveCte(chaveCte);
        responseEmissao.setStatus("200");*/

        return responseEmissao;
    }

}
