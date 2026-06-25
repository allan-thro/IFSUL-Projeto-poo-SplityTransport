package com.pwzt.ifsul.splitytransport.api.dto.request.cadastro;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class VeiculoDTO {

    private String placa;
    private String marca;
    private String modelo;
    private String eixos;
    private String rntrc;

    @JsonProperty("capacidade_maxima")
    private BigDecimal capacidadeMaxima;

}
