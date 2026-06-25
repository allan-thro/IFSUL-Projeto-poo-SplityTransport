package com.pwzt.ifsul.splitytransport.core.exception;

import com.pwzt.ifsul.splitytransport.api.dto.response.ResponseMensagem;
import lombok.Getter;

import java.util.List;

@Getter
public class TransporteValidationException extends RuntimeException {
    List<ResponseMensagem> erroList;

    public TransporteValidationException(String message, List<ResponseMensagem> erroList) {
        this.erroList = erroList;
        super(message);
    }

    public TransporteValidationException(String message){
        super(message);
    }
}
