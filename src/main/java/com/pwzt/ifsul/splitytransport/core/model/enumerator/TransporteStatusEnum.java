package com.pwzt.ifsul.splitytransport.core.model.enumerator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

public enum TransporteStatusEnum {
    CANCELADO(1, "Cancelado"),
    DOCUMENTOS_AUTORIZADOS(2, "Documentos Autorizados"),
    EM_TRANSITO(3, "Em Trânsito"),
    ENTREGUE(4, "Entregue"),
    RASCUNHO(5, "Rascunho");

    private final Integer codigo;
    private final String descricao;

    public static TransporteStatusEnum fromCodigo(String descricao){
        for(TransporteStatusEnum statusEnum : TransporteStatusEnum.values()){
            if(statusEnum.getDescricao().equalsIgnoreCase(descricao)) return statusEnum;
        }
        throw new IllegalArgumentException("Enumerator Status inválido");
    }
}
