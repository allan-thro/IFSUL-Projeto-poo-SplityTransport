package com.pwzt.ifsul.splitytransport.core.model.base;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "GBL_FIL")
@Entity
@Data

public class Filial {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FIL_ID")
    private Long id;

    @Column(name = "FIL_CNPJ")
    private String cnpj;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "FIL_ENDERECO", referencedColumnName = "END_ID")
    private Endereco enderecoSede;

    @Column(name = "FIL_RAZAOSOCIAL")
    private String razaoSocial;

    @Column(name = "FIL_NOME")
    private String nomeFantasia;

}
