package com.pwzt.ifsul.splitytransport.core.model.base;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "GBL_VEI", indexes = {
    @Index(columnList = "VEI_PLACA")
})
@Entity
@Data

@AllArgsConstructor
@NoArgsConstructor
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

    @Column(name = "VEI_RNTRC")
    private String rntrc;

    @Column(name = "VEI_CAPACIDADEMAXIMA", precision = 8, scale = 2)
    private BigDecimal capacidadeMaxima;

}
