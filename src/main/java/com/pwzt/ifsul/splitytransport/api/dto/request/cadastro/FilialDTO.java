package com.pwzt.ifsul.splitytransport.api.dto.request.cadastro;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FilialDTO{

    private String cnpj;

    @JsonProperty("endereco_sede")
    private EnderecoDTO enderecoSede;

    @JsonProperty("razao_social")
    private String razaoSocial;

    @JsonProperty("nome_fantasia")
    private String nomeFantasi;

}
