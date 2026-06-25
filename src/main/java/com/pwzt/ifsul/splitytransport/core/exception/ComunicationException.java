package com.pwzt.ifsul.splitytransport.core.exception;

import com.pwzt.ifsul.splitytransport.api.dto.response.ResponseMensagem;
import lombok.Data;
import lombok.Getter;

@Getter
public class ComunicationException extends RuntimeException {
    private ResponseMensagem erro;

    public ComunicationException(ResponseMensagem mensagem) {
        this.erro = erro;
    }

    public ComunicationException(String mensagem) {
        super(mensagem);
    }
}
