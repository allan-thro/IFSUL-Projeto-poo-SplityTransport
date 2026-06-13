package com.pwzt.ifsul.splitytransport.core.complextype.cte;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Data

@XmlAccessorType(XmlAccessType.FIELD)
public class TcDest {

    @JsonProperty("cnpj")
    private String CNPJ;

    @JsonProperty("nome_destinatario")
    private String xNome;

    @XmlElement(name = "enderDest")
    @JsonProperty("endereco_destino")
    private TcEndereco tcEndereco;

}
