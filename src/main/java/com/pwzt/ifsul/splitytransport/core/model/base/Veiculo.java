package com.pwzt.ifsul.splitytransport.core.model.base;

import jakarta.persistence.*;

@Table(name = "GBL_VEI", indexes = {
    @Index(columnList = "VEI_PLACA")
})
@Entity

public class Veiculo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "VEI_PLACA")
    private String placa;

    @Column(name = "VEI_MARCA")
    private String marca;

    @Column(name = "VEI_MODELO")
    private String modelo;

    @Column(name = "VEI_EIXOS")
    private String eixos;

}
