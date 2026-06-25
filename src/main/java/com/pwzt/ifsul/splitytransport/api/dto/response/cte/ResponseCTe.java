package com.pwzt.ifsul.splitytransport.api.dto.response.cte;

import com.pwzt.ifsul.splitytransport.api.dto.response.ResponseMensagem;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data

public class ResponseCTe {

    private String status;

    private List<ResponseMensagem> mensagemList;

}
