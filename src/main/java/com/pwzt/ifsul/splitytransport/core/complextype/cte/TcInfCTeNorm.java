package com.pwzt.ifsul.splitytransport.core.complextype.cte;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlElement;

public class TcInfCTeNorm {

    @XmlElement(name = "infCarga")
    @JsonProperty("informacao_carga")
    private TcInfCarga tcInfCarga;

    @XmlElement(name = "infDoc")
    @JsonProperty("informacao_documento")
    private TcInfDoc tcInfDoc;

}
