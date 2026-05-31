package com.pwzt.ifsul.splitytransport.core.model.enumerator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

public enum TransporteStatusEnum {
    RASCUNHO("Rascunho");

    private final String codigo;

    public static TransporteStatusEnum fromCodigo(String cod){
        for(TransporteStatusEnum statusEnum : TransporteStatusEnum.values()){
            if(statusEnum.getCodigo().equalsIgnoreCase(cod)) return statusEnum;
        }
        throw new IllegalArgumentException("Enumerator Status inválido");
    }
}
