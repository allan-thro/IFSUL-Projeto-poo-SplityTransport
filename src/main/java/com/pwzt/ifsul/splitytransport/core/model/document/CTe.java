package com.pwzt.ifsul.splitytransport.core.model.document;

import com.pwzt.ifsul.splitytransport.core.model.base.Cliente;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "CTE_CTE")
@Entity
@Data
public class CTe extends Documento{

    @Column(name = "CTE_CHAVE")
    private String chaveCte;

    @Column(name = "CTE_CODOPER")
    private String codigoOperacao;

    @Column(name = "CTE_NUMCTE")
    private String numeroCte;

    @Column(name = "CTE_DHEMISSAO")
    private LocalDateTime dataHoraEmissao;

    @Column(name = "CTE_MUNEMISSOR")
    private String municipioEmissor;

    @Column(name = "CTE_MUNORIGEM")
    private String municipioOrigem;

    @Column(name = "CTE_MUNSDET")
    private String municipioDestino;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CLI_CODIGO")
    @Column(name = "CTE_EMITENTE")
    private Cliente emitente;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CLI_CODIGO")
    @Column(name = "CTE_REMETENTE")
    private Cliente remetente;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CLI_CODIGO")
    @Column(name = "CTE_DESTINATARIO")
    private Cliente destinatario;

    @Column(name = "CTE_VALORLIQUIDO")
    private BigDecimal valorLiquido;

    @Column(name = "CTE_PESOCARGA")
    private BigDecimal pesoCarga;

    @Column(name = "CTE_VALORMERCADORIA")
    private BigDecimal valorMercadoria;

    @Column(name = "CTE_CHAVENFE")
    private String chaveNfe;

}

