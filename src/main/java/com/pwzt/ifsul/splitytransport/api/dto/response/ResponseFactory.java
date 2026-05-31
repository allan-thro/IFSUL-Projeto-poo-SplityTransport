package com.pwzt.ifsul.splitytransport.api.dto.response;

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

    public static ResponseApi cadastroSucesso(String status, Pair<String, String> p){
        ArrayList<Mensagem> mensagemRetorno = new ArrayList<>();

        Mensagem mensagem = new Mensagem(p.first(), p.second());
        mensagemRetorno.add(mensagem);

        return new ResponseApi("200", LocalDateTime.now(), mensagemRetorno);
    }

}
