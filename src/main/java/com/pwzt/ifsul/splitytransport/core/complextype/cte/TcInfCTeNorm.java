package com.pwzt.ifsul.splitytransport.core.complextype.cte;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Data

@XmlAccessorType(XmlAccessType.FIELD)
public class TcInfCTeNorm {

    @XmlElement(name = "infCarga")
    @JsonProperty("informacao_carga")
    private TcInfCarga tcInfCarga;

    @XmlElement(name = "infDoc")
    @JsonProperty("informacao_documento")
    private TcInfDoc tcInfDoc;

}
