package com.pwzt.ifsul.splitytransport.api.dto.response.cte;

import com.pwzt.ifsul.splitytransport.api.dto.response.Mensagem;
import com.pwzt.ifsul.splitytransport.core.model.states.DocStatus;
import lombok.Data;

import java.util.ArrayList;

@Data

public class ResponseCTe {

    private String status;

    private ArrayList<Mensagem> mensagemList;

}
