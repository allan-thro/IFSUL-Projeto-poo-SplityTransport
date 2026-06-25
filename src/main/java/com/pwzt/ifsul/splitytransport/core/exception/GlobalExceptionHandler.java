package com.pwzt.ifsul.splitytransport.core.exception;

import com.pwzt.ifsul.splitytransport.api.dto.response.ResponseApi;
import com.pwzt.ifsul.splitytransport.core.factory.ResponseFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DocumentoValidationException.class)
    public ResponseEntity<ResponseApi> handleDocumentoValidationException(DocumentoValidationException e){
        ResponseApi response = ResponseFactory.createResponseDocumentoValidationException(e);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(ComunicationException.class)
    public ResponseEntity<ResponseApi> handleComunicationException(ComunicationException e){
        ResponseApi response = ResponseFactory.createResponseComunicationException(e);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(TransporteValidationException.class)
    public ResponseEntity<ResponseApi> handleTransporteValidationException(TransporteValidationException e){
        ResponseApi response = ResponseFactory.createResponseTransporteValidationException(e);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseApi> handleOveralExceptio(Exception e){
        ResponseApi response = ResponseFactory.createResponseOveralExceptio(e);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
