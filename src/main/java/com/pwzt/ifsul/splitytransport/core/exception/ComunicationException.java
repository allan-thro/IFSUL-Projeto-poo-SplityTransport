package com.pwzt.ifsul.splitytransport.core.exception;

import com.pwzt.ifsul.splitytransport.api.dto.response.ResponseMensagem;

public class ComunicationException extends RuntimeException {
    private ResponseMensagem mensagem;

    public ComunicationException(ResponseMensagem mensagem) {
        this.mensagem = mensagem;
    }

    public ComunicationException(String mensagem) {
        super(mensagem);
    }
}
