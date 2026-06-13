package com.pwzt.ifsul.splitytransport.core.complextype.cte;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.lang.reflect.Array;
import java.util.ArrayList;

@NoArgsConstructor
@Data

@XmlAccessorType(XmlAccessType.FIELD)
public class TcVPrest {

    @JsonProperty("valor_total_transporte")
    private String vTPrest;

    @JsonProperty("valor_liquido")
    private String vRec;

    @XmlElement(name = "comp")
    @JsonProperty("complemento_list")
    private ArrayList<TcComp> tcCompList;

}
