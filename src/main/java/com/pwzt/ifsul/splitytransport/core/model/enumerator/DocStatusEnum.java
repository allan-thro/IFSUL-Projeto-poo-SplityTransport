package com.pwzt.ifsul.splitytransport.core.model.enumerator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

public enum DocStatusEnum {
    AUTORIZADO("Autorizado"),
    CANCELADO("Cancelado"),
    DENEGADO("Denegado"),
    PENDENTE("Pendente"),
    RASCUNHO("Rascunho"),
    REJEITADO("Rejeitado");

    private final String codigo;

    public static DocStatusEnum fromCodigo(String cod){
        for(DocStatusEnum statusEnum : DocStatusEnum.values()){
            if(statusEnum.getCodigo().equalsIgnoreCase(cod)) return statusEnum;
        }
        throw new IllegalArgumentException("Enumerator Status inválido");
    }
}
