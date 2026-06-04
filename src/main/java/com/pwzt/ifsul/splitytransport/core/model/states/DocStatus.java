package com.pwzt.ifsul.splitytransport.core.model.states;

import com.pwzt.ifsul.splitytransport.core.model.document.Documento;

public interface DocStatus<T extends Documento> {
    void emitir(T doc);
    void cancelar(T doc);
    void consultar(T doc);
    void autorizar(T doc);
    void rejeitar(T doc);
    void corrigir(T doc);
}
