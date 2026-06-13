package com.pwzt.ifsul.splitytransport.core.model.base;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

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

    @Convert(converter = TipoCarroceriaConverter.class)
    @Column(name = "VEI_TIPOCARROCERIA")
    private TipoCarroceria tipoCarroceria;

    @Column(name = "VEI_CAPACIDADEMAXIMA", scale = 15, precision = 2)
    private BigDecimal capacidadeMaxima;

}
