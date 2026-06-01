package com.pwzt.ifsul.splitytransport.core.model.document;

import com.pwzt.ifsul.splitytransport.core.model.base.Endereco;
import com.pwzt.ifsul.splitytransport.core.model.base.Filial;
import com.pwzt.ifsul.splitytransport.core.model.base.Motorista;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CollectionIdMutability;

import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "CIO_CIO")
@Entity
@Data

public class CIOT extends Documento{

    @Column(name = "CIO_CODOPER")
    private String codigoOperacao;

    @ManyToOne
    @JoinColumn(name = "CIO_CONTRATANTE", referencedColumnName = "FIL_ID")
    private Filial contratante;

    @ManyToOne
    @JoinColumn(name = "CIO_MOTORISTA", referencedColumnName = "MOT_ID")
    private Motorista contratado;

    @ManyToOne
    @JoinColumn(name = "CIO_ORIGEM", referencedColumnName = "END_ID")
    private Endereco origem;

    @ManyToOne
    @JoinColumn(name = "CIO_DESTINO", referencedColumnName = "END_ID")
    private Endereco destino;

    @Column(name = "CIO_DHINICIO")
    private LocalDate dataInicioPrevista;

    @Column(name = "CIO_DHFIM")
    private LocalDate dataFimPrevista;

    @Column(name = "CIO_VALORFRETE")
    private BigDecimal valorFrete;

    @Column(name = "CIO_FORMAPAGAMENTO")
    private String formaPagamento;

    @Column(name = "CIO_CHAVECTE")
    private String chaveCte;

}
