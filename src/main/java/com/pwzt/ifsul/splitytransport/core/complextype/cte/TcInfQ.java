package com.pwzt.ifsul.splitytransport.core.complextype.cte;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TcInfQ {

    @JsonProperty("unidade_de_medida")
    private String cUnid;

    @JsonProperty("tipo_medida")
    private String tpMed;

    @JsonProperty("peso")
    private String qCarga;

}
