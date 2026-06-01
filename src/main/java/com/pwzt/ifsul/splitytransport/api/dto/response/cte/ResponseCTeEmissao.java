package com.pwzt.ifsul.splitytransport.api.dto.response.cte;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseCTeEmissao extends ResponseCTe{

    private String motivo;

    @JsonProperty("numero_protocolo")
    private String numeroProtocolo;

    @JsonProperty("data_processamento")
    private String dataProcessamento;



}
