package com.pwzt.ifsul.splitytransport.core.complextype.cte;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class TcComp {

    @JsonProperty("nome_complemento")
    private String xNome;

    @JsonProperty("valor_complemento")
    private String vComp;

}
