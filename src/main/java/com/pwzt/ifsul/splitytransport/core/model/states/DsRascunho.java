package com.pwzt.ifsul.splitytransport.core.model.states;

import com.pwzt.ifsul.splitytransport.core.model.document.Documento;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DsRascunho implements DocStatus{

    @Override
    public void emitir(Documento doc) {
        doc.setStatus(new DsPendente());
        log.info(String.format("Documento com chave $s em pendência", doc.getChave()));
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
