package com.pwzt.ifsul.splitytransport.core.validation;

import com.pwzt.ifsul.splitytransport.api.dto.response.ResponseMensagem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ValidationResult {

    private boolean valido;
    private List<ResponseMensagem> erroList;

    public ValidationResult(List<ResponseMensagem> erroList){
        this.valido = (erroList.isEmpty());
        this.erroList = erroList;
    }
}
