package com.pwzt.ifsul.splitytransport.core.complextype.cte;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Data

@XmlAccessorType(XmlAccessType.FIELD)
public class TcInfQ {

    @JsonProperty("unidade_de_medida")
    private String cUnid;

    @JsonProperty("tipo_medida")
    private String tpMed;

    @JsonProperty("peso")
    private String qCarga;

}
