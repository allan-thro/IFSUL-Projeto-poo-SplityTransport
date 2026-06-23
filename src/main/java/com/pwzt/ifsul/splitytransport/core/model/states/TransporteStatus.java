package com.pwzt.ifsul.splitytransport.core.model.states;

import com.pwzt.ifsul.splitytransport.api.dto.response.ResponseMensagem;
import com.pwzt.ifsul.splitytransport.core.model.base.Transporte;
import com.pwzt.ifsul.splitytransport.core.validation.ValidationResult;

public interface TransporteStatus {
    ResponseMensagem autorizar();
    ResponseMensagem iniciar();
    ResponseMensagem concluir();
    ResponseMensagem cancelar();
}
