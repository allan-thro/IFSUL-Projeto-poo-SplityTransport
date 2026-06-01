package com.pwzt.ifsul.splitytransport.api.dto.request.cadastro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class MotoristaDTO {

    private String nome;

    private String numero;

    private String email;

    private String cpf;

    private String RNTR;

}
