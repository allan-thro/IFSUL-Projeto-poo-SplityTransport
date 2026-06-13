package com.pwzt.ifsul.splitytransport.api.dto.response.cadastro;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data

public class ResponseCadastroVeiculoAntt extends ResponseCadastroBaseAntt {

    @JsonProperty("tipo_carroceria")
    private String tipoCarroceria;

    @JsonProperty("capacidade_maxima_carga_kg")
    private String capacidadeMaximaCargaKg;

    private String placa;

}