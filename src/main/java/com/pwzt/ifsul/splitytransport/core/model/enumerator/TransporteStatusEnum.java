package com.pwzt.ifsul.splitytransport.core.model.enumerator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

public enum TransporteStatusEnum {
    RASCUNHO(1, "Rascunho");

    private final Integer codigo;
    private final String descricao;

    public static TransporteStatusEnum fromCodigo(String descricao){
        for(TransporteStatusEnum statusEnum : TransporteStatusEnum.values()){
            if(statusEnum.getDescricao().equalsIgnoreCase(descricao)) return statusEnum;
        }
        throw new IllegalArgumentException("Enumerator Status inválido");
    }
}
