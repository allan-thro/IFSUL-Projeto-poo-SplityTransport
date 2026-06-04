package com.pwzt.ifsul.splitytransport.core.complextype.cte;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class TcInfQ {

    @JsonProperty("unidade_de_medida")
    private String cUnid;

    @JsonProperty("tipo_medida")
    private String tpMed;

    @JsonProperty("peso")
    private String qCarga;

}
