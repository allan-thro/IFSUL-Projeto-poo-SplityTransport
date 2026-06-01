package com.pwzt.ifsul.splitytransport.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ResponseApi {

    private String status;

    private LocalDateTime timestamp;

    private ArrayList<Mensagem> mensagemList;

}
