package com.pwzt.ifsul.splitytransport.core.complextype.cte;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlElement;

public class TcDest {

    @JsonProperty("cnpj")
    private String CNPJ;

    @JsonProperty("nome_destinatario")
    private String xNome;

    @XmlElement(name = "enderDest")
    @JsonProperty("endereco_destino")
    private TcEndereco tcEndereco;

}
