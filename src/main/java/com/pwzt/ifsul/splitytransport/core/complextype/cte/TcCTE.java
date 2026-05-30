package com.pwzt.ifsul.splitytransport.core.complextype.cte;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlElement;

public class TcCTE {

    @XmlElement(name = "infCte")
    @JsonProperty("inf_cte")
    private TcInfCTE infCTE;

}
