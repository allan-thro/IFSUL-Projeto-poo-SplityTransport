package com.pwzt.ifsul.splitytransport.core.exception;

import com.pwzt.ifsul.splitytransport.api.dto.response.ResponseMensagem;
import lombok.Getter;

import java.util.List;

@Getter
public class DocumentoValidationException extends RuntimeException {
    private ResponseMensagem erro;

    public DocumentoValidationException(String mensagem, ResponseMensagem erro) {
        super(mensagem);
        this.erro = erro;
    }

    public DocumentoValidationException(String mensagem){
        super(mensagem);
    }
}
