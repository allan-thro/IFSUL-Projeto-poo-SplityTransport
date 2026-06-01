package com.pwzt.ifsul.splitytransport.api.dto.response.cte;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class ResponseCTeConsulta extends ResponseCTe{

    @JsonProperty("chave_cte")
    private String chaveCte;

    @JsonProperty("protocolo_autorizacao")
    private String protocoloAutorizacao;

    @JsonProperty("historico_eventos")
    private ArrayList<CTeEvento> historicoEventos;

}
