package com.pwzt.ifsul.splitytransport.core.complextype.cte;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlElement;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TcVPrest {

    @JsonProperty("valor_total_transporte")
    private String vTPrest;

    @JsonProperty("valor_liquido")
    private String vRec;

    @XmlElement(name = "comp")
    @JsonProperty("complemento_list")
    private ArrayList<TcComp> tcCompList;

}
