package com.pwzt.ifsul.splitytransport.core.factory;

import com.pwzt.ifsul.splitytransport.api.dto.response.Mensagem;
import com.pwzt.ifsul.splitytransport.api.dto.response.ResponseApi;
import com.pwzt.ifsul.splitytransport.api.dto.response.cadastro.ResponseCadastroMotoristaAntt;
import com.pwzt.ifsul.splitytransport.api.dto.response.cte.ResponseCTeEmissao;
import com.pwzt.ifsul.splitytransport.core.utils.Pair;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ResponseFactory {

    public static ResponseApi cadastroSucesso(String status, ArrayList<Pair<String, String>> mensagemList){
        ArrayList<Mensagem> mensagemRetorno = new ArrayList<>();

        for(Pair<String, String> p : mensagemList){
            Mensagem mensagem = new Mensagem(p.first(), p.second());
            mensagemRetorno.add(mensagem);
        }

        return new ResponseApi("200", LocalDateTime.now(), mensagemRetorno);
    }

    public static ResponseApi cadastroMotoristaAntt(ResponseCadastroMotoristaAntt response){
        ArrayList<Mensagem> mensagemRetorno = new ArrayList<>();

        Mensagem mensagem = new Mensagem(response.getCodigoStatusAntt(), response.getMotivoAntt());
        mensagemRetorno.add(mensagem);

        return new ResponseApi("200", LocalDateTime.now(), mensagemRetorno);
    }

    public static ResponseCTeEmissao emissaoCTeSucesso(String chaveCte){
        ResponseCTeEmissao responseEmissao = new ResponseCTeEmissao();
        ArrayList<Mensagem> mensagemRetorno = new ArrayList<>();

        Mensagem mensagem = new Mensagem("105", "CTe enviada para a fila de emissão, consulte pela chave para obter detalhes do processamento");
        mensagemRetorno.add(mensagem);

        responseEmissao.setDataEmissao(LocalDateTime.now());
        responseEmissao.setMensagemList(mensagemRetorno);
        responseEmissao.setChaveCte(chaveCte);
        responseEmissao.setStatus("200");

        return responseEmissao;
    }

}
