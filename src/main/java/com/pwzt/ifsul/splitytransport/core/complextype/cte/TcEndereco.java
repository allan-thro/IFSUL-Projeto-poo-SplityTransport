package com.pwzt.ifsul.splitytransport.core.complextype.cte;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Data

@XmlAccessorType(XmlAccessType.FIELD)
public class TcEndereco {

    @JsonProperty("nome_logradouro")
    private String xlgr;

    @JsonProperty("numero")
    private String nro;

    @JsonProperty("nome_bairro")
    private String xBairro;

    @JsonProperty("codigo_municipio")
    private String cMun;

    @JsonProperty("nome_municipio")
    private String xMun;

    @JsonProperty("uf")
    private String UF;

}
