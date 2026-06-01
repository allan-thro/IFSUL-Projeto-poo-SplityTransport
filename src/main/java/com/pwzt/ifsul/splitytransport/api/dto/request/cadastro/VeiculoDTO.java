package com.pwzt.ifsul.splitytransport.api.dto.request.cadastro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class VeiculoDTO {

    private String placa;

    private String marca;

    private String modelo;

    private String eixos;

}
