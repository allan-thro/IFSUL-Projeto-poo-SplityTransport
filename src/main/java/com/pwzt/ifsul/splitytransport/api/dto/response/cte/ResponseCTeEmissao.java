package com.pwzt.ifsul.splitytransport.api.dto.response.cte;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data

public class ResponseCTeEmissao extends ResponseCTe{

    @JsonProperty("chave_cte")
    private String chaveCte;

    @JsonProperty("data_emissao")
    private LocalDateTime dataEmissao;



}
