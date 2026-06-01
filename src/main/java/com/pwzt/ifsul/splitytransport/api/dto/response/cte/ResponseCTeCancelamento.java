package com.pwzt.ifsul.splitytransport.api.dto.response.cte;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseCTeCancelamento extends ResponseCTe{

        @JsonProperty("motivo_sefaz")
        private String motivoSefaz;

        @JsonProperty("protocolo_cancelamento")
        private String protocoloCancelamento;

        private String justificativa;

        @JsonProperty("data_cancelamento")
        private String dataCancelamento;

}
