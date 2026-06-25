package com.pwzt.ifsul.splitytransport.core.model.states;

import com.pwzt.ifsul.splitytransport.api.dto.response.ResponseMensagem;
import com.pwzt.ifsul.splitytransport.core.model.base.Transporte;
import com.pwzt.ifsul.splitytransport.core.model.enumerator.TransporteStatusEnum;
import com.pwzt.ifsul.splitytransport.core.validation.ValidationResult;

public interface TransporteStatus {
    TransporteStatusEnum estadoAtual();
    boolean podeAutorizar();
    boolean podeIniciar();

    void autorizar(Transporte transporte);
    void iniciar(Transporte transporte);
    void concluir(Transporte transporte);
    void cancelar(Transporte transporte);
}
