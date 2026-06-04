package com.pwzt.ifsul.splitytransport.core.complextype.cte;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class TcInfCarga {

    @JsonProperty("valor_mercadorias")
    private String vCarga;

    @JsonProperty("produto_predominante")
    private String prodPred;

    @XmlElement(name = "infQ")
    @JsonProperty("informacao_q")
    private TcInfQ tcInfQ;

}
