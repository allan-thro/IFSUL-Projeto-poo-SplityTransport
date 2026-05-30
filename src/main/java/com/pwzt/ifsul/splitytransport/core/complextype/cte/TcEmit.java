package com.pwzt.ifsul.splitytransport.core.complextype.cte;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlElement;

public class TcEmit {

    @JsonProperty("cnpj")
    private String CNPJ;

    @JsonProperty("inscricao_estadual")
    private String IE;

    @JsonProperty("razao_social")
    private String xNome;

    @XmlElement(name = "enderEmit")
    @JsonProperty("endereco_emitente")
    private TcEndereco tcEndereco;

}
