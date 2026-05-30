package com.pwzt.ifsul.splitytransport.core.complextype.cte;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlElement;

public class TcRem {

    @JsonProperty("cnpj")
    private String CNPJ;

    @JsonProperty("inscricao_estadual")
    private String IE;

    @JsonProperty("nome_remetente")
    private String xNome;

    @XmlElement(name = "enderReme")
    @JsonProperty("endereco_remetente")
    private TcEndereco tcEndereco;

}
