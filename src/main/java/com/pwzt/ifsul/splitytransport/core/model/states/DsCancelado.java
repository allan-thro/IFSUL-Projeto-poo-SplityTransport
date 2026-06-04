package com.pwzt.ifsul.splitytransport.core.model.states;

import com.pwzt.ifsul.splitytransport.core.exception.DocumentoValidationException;
import com.pwzt.ifsul.splitytransport.core.model.document.Documento;

public class DsCancelado implements DocStatus{

    @Override
    public void emitir(Documento doc) {
        throw new DocumentoValidationException("Não é possivel emitir documento já cancelado");
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
