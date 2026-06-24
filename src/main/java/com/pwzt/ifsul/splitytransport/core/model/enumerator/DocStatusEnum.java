package com.pwzt.ifsul.splitytransport.core.model.enumerator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

public enum DocStatusEnum {
    AUTORIZADO(1, "Autorizado"),
    CANCELADO(2, "Cancelado"),
    DENEGADO(3, "Denegado"),
    PENDENTE(4, "Pendente"),
    RASCUNHO(5, "Rascunho"),
    REJEITADO(6, "Rejeitado");

    private final Integer codigo;
    private final String descricao;

    public static DocStatusEnum fromDescricao(String descricao){
        for(DocStatusEnum statusEnum : DocStatusEnum.values()){
            if(statusEnum.getDescricao().equalsIgnoreCase(descricao)) return statusEnum;
        }
        throw new IllegalArgumentException("Enumerator Status inválido");
    }
}
