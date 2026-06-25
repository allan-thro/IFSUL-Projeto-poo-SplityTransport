package com.pwzt.ifsul.splitytransport.api.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseApi {

    private String status;
    private String motivo;
    private LocalDateTime timestamp;
    private ArrayList<ResponseMensagem> mensagemList;

    public void addMensagem(ResponseMensagem mensagem){
        if(this.mensagemList == null) this.mensagemList = new ArrayList<>();
        this.mensagemList.add(mensagem);
    }

}
