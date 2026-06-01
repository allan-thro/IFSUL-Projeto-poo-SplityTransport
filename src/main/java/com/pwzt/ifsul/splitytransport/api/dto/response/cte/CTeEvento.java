package com.pwzt.ifsul.splitytransport.api.dto.response.cte;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CTeEvento {

    @JsonProperty("chave_cte")
    private String chaveCte;

    private String evento;

    private String data;

}
