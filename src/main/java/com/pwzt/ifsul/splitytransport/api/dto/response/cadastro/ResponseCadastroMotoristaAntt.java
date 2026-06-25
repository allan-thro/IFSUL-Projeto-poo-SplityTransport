package com.pwzt.ifsul.splitytransport.api.dto.response.cadastro;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data

public class ResponseCadastroMotoristaAntt extends ResponseCadastroBaseAntt {

    @JsonProperty("documento_filiado")
    private String documentoFiliado;

    @JsonProperty("nome_filiado")
    private String nomeFiliado;

    @JsonProperty("situacao_rntrc")
    private String situacaoRntrc;

    @JsonProperty("validade_rtrc")
    private LocalDate validadeRntrc;

}
