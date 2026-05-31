package com.pwzt.ifsul.splitytransport.core.model.base;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "GBL_END")
@Entity
@Data

public class Endereco {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "END_ID")
    private Long id;

    @Column(name = "END_CEP")
    private String cep;

    @Column(name = "END_LOGRADOURO")
    private String logradouro;

    @Column(name = "END_NUMERO")
    private String numero;
    @Column(name = "END_BAIRRO")
    private String bairro;

    @Column(name = "END_CODMUNICIPIO")
    private String codMunicipio;

    @Column(name = "END_NOMEMUNICIPIO")
    private String nomeMunicipio;

    @Column(name = "END_UF")
    private String uf;

}
