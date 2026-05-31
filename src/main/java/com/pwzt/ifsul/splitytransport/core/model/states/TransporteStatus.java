package com.pwzt.ifsul.splitytransport.core.model.states;

public interface TransporteStatus {
    void autorizar();
    void iniciar();
    void concluir();
    void cancelar();
}
