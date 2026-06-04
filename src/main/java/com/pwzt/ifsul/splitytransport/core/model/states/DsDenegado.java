package com.pwzt.ifsul.splitytransport.core.model.states;

import com.pwzt.ifsul.splitytransport.core.model.document.Documento;

public class DsDenegado implements DocStatus {
    @Override
    public void emitir(Documento doc) {

    }

    @Override
    public void cancelar(Documento doc) {

    }

    @Override
    public void consultar(Documento doc) {

    }

    @Override
    public void autorizar(Documento doc) {

    }

    @Override
    public void rejeitar(Documento doc) {

    }

    @Override
    public void corrigir(Documento doc) {

    }
}
