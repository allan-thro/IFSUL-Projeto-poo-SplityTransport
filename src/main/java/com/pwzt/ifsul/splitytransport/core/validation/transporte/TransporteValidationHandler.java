package com.pwzt.ifsul.splitytransport.core.validation.transporte;

import com.pwzt.ifsul.splitytransport.api.dto.response.ResponseMensagem;
import com.pwzt.ifsul.splitytransport.core.model.base.Transporte;
import com.pwzt.ifsul.splitytransport.core.validation.ValidationResult;

import java.util.List;

public abstract class TransporteValidationHandler {

    private TransporteValidationHandler proximo;

    public TransporteValidationHandler setProximo(TransporteValidationHandler proximo){
        this.proximo = proximo;
        return proximo;
    }

    public final void handle(Transporte transporte, List<ResponseMensagem> mensagensErro){
        ValidationResult result = validar(transporte);

        if(!result.isValido()){
            for(ResponseMensagem message : result.getErroList()){
                mensagensErro.add(message);
            }
        }

        if(proximo != null){
            proximo.handle(transporte, mensagensErro);
        }
    }

    protected abstract ValidationResult validar(Transporte transporte);

}
