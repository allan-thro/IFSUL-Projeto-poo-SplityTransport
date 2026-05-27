package com.pwzt.ifsul.splitytransport.core.model.states;

public interface DocStatus {
    void emitir();
    void cancelar();
    void consultar();
    void autorizar();
    void rejeitar();
    void corrigir();
}
