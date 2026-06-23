package com.pwzt.ifsul.splitytransport.api.dto.response.cte;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pwzt.ifsul.splitytransport.core.model.enumerator.DocStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ResponseCTeEmissao extends ResponseCTe{

    @JsonProperty("chave_cte")
    private String chaveCte;

    @JsonProperty("data_autorizacao")
    private LocalDateTime dataAutorizacao;

    private DocStatusEnum status;
    private String protocolo;
    private String codigo;
    private String motivo;

}
