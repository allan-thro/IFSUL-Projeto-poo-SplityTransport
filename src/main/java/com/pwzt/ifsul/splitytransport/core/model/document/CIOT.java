package com.pwzt.ifsul.splitytransport.core.model.document;

import com.pwzt.ifsul.splitytransport.core.model.base.Endereco;
import com.pwzt.ifsul.splitytransport.core.model.base.Filial;
import com.pwzt.ifsul.splitytransport.core.model.base.Motorista;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "CIO_CIO")
@Entity
@Data

public class CIOT extends Documento{

    private String codigoOperacao;

    private Filial contratante;

    private Motorista contratado;

    private Endereco origem;

    private Endereco destino;

    private LocalDate dataInicioPrevista;

    private LocalDate dataFimPrevista;

    private BigDecimal valorFrete;

    private String formaPagamento;

    private String chaveCte;

}
