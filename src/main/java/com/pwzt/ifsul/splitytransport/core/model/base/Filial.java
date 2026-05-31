package com.pwzt.ifsul.splitytransport.core.model.base;

import jakarta.persistence.*;

@Table(name = "GBL_FIL")
@Entity

public class Filial {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FIL_ID")
    private Long id;

    @Column(name = "FIL_CNPJ")
    private String cnpj;

    @OneToOne
    @JoinColumn(name = "END_ID")
    @Column(name = "FIL_ENDERECO")
    private Endereco enderecoSede;

    @Column(name = "FIL_RAZAOSOCIAL")
    private String razaoSocial;

    @Column(name = "FIL_NOME")
    private String nomeFantasia;

}
