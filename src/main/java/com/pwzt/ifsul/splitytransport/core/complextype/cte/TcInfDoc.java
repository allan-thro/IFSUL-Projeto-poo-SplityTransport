package com.pwzt.ifsul.splitytransport.core.complextype.cte;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class TcInfDoc {

    @XmlElement(name = "infNfe")
    @JsonProperty("informacao_nfe")
    private TcInfNfe tcInfNfe;

}
