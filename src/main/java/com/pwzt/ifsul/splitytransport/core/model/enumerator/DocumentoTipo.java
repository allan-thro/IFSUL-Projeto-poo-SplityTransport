package com.pwzt.ifsul.splitytransport.core.model.enumerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter

public enum DocumentoTipo {

    CTE("cte"),
    CIOT("ciot"),
    MDFE("mdfe");

    private final String path;

    public static DocumentoTipo fromPath(String path) {
        for(DocumentoTipo dtc : DocumentoTipo.values()) {
            if(dtc.path.equalsIgnoreCase(path)) return dtc;
        }

        throw new IllegalArgumentException("Tipo do documento inválido");
    }

}


