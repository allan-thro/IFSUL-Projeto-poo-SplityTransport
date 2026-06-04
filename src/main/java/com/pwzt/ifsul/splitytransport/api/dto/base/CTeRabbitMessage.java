package com.pwzt.ifsul.splitytransport.api.dto.base;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data

public class CTeRabbitMessage {

    private String xml;

    private String chave;

    private Long transportId;

}
