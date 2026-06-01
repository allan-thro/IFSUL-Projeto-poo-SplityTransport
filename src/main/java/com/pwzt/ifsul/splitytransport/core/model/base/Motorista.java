package com.pwzt.ifsul.splitytransport.core.model.base;

import jakarta.persistence.*;
import tools.jackson.databind.introspect.BasicClassIntrospector;

@Table(name = "GBL_MOT", indexes = {
        @Index(columnList = "MOT_CPF")
})
@Entity

public class Motorista {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MOT_ID")
    private Long id;

    @Column(name = "MOT_NOME")
    private String nome;

    @Column(name = "MOT_NUMERO")
    private String numero;

    @Column(name = "MOT_EMAIL")
    private String email;

    @Column(name = "MOT_CPF")
    private String cpf;

    @Column(name = "MOT_RNTRC")
    private String RNTRC;

}
