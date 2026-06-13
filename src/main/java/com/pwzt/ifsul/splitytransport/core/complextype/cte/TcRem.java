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
