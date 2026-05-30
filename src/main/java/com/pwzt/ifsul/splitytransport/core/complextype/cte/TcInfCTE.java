package com.pwzt.ifsul.splitytransport.core.complextype.cte;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlElement;

public class TcInfCTE {

    @XmlElement(name = "ide")
    @JsonProperty("identificacao")
    private TcIde tcIde;

    @XmlElement(name = "emit")
    @JsonProperty("emitente")
    private TcEmit tcEmit;

    @XmlElement(name = "rem")
    @JsonProperty("remetente")
    private TcRem tcRem;

    @XmlElement(name = "dest")
    @JsonProperty("destinatario")
    private TcDest tcDest;

    @XmlElement(name = "vPrest")
    @JsonProperty("valores_prestacao")
    private TcVPrest tcVPrest;

    @XmlElement(name = "infCTeNorm")
    @JsonProperty("informacao_carga")
    private TcInfCTeNorm tcInfCTeNorm;

}
