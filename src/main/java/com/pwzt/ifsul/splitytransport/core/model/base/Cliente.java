package com.pwzt.ifsul.splitytransport.core.model.base;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "GBL_CLI")
@Entity
@Data

public class Cliente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLI_ID")
    private Long id;

    @Column(name = "CLI_CPFCNPJ")
    private String cpfCnpj;

    @Column(name = "CLI_IE")
    private String inscricaoEstadual;

    @Column(name = "CLI_RAZAOSOCIAL")
    private String razaoSocial;

    @ManyToOne
    @JoinColumn(name = "END_ID")
    @Column(name = "CLI_ENDERECO")
    private Endereco endereco;

}
