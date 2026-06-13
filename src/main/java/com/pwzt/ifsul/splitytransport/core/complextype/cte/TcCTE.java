package com.pwzt.ifsul.splitytransport.core.complextype.cte;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Data

@XmlRootElement(name = "CTe", namespace = "http://www.portalfiscal.inf.br/cte")
@XmlAccessorType(XmlAccessType.FIELD)
public class TcCTE {

    @XmlElement(name = "infCte")
    @JsonProperty("inf_cte")
    private TcInfCTE infCTE;

}
