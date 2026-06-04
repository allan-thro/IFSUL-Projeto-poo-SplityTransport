package com.pwzt.ifsul.splitytransport.core.model.base;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "GBL_VEI", indexes = {
    @Index(columnList = "VEI_PLACA")
})
@Entity
@Data

public class Veiculo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VEI_ID")
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
