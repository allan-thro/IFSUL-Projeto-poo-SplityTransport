package com.pwzt.ifsul.splitytransport.core.model.states;

import com.pwzt.ifsul.splitytransport.api.dto.response.ResponseMensagem;

public class TsCancelado implements TransporteStatus{
    @Override
    public ResponseMensagem autorizar() {
        return new ResponseMensagem.Builder()
                .descricao("Não é possivel autorizar um documento cancelado")
                .codigo("110")
                .erro()
                .build();
    }

    @Override
    public ResponseMensagem iniciar() {
        return new ResponseMensagem.Builder()
                .descricao("Não é possivel iniciar viagem já cancelada")
                .codigo("110")
                .erro()
                .build();
    }

    @Override
    public ResponseMensagem concluir() {
        return new ResponseMensagem.Builder()
                .descricao("Não é possivel concluir uma viajem cancelada")
                .codigo("110")
                .erro()
                .build();
    }

    @Override
    public ResponseMensagem cancelar() {

        return new ResponseMensagem.Builder()
                .descricao("Viagem cancelada com sucesso")
                .codigo("200")
                .sucesso()
                .build();

    }

}
