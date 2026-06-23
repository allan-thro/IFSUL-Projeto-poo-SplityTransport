package com.pwzt.ifsul.splitytransport.core.model.states;

import com.pwzt.ifsul.splitytransport.api.dto.response.ResponseMensagem;

public class TsEntregue implements TransporteStatus{
    @Override
    public ResponseMensagem autorizar() {
        return null;
    }

    @Override
    public ResponseMensagem iniciar() {
        return null;
    }

    @Override
    public ResponseMensagem concluir() {
        return null;
    }

    @Override
    public ResponseMensagem cancelar() {
        return null;
    }
}
