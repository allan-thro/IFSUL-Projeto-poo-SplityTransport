package com.pwzt.ifsul.splitytransport.api.dto.request.cadastro;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class EnderecoDTO{

    private String cep;

    private String logradouro;

    private String numero;

    private String bairro;

    @JsonProperty("codigo_municipio")
    private String codMunicipio;

    @JsonProperty("nome_municipio")
    private String nomeMunicipio;

    private String uf;

}
