package com.pwzt.ifsul.splitytransport.core.model.base;

import com.pwzt.ifsul.splitytransport.core.factory.DocumentoFactory;
import com.pwzt.ifsul.splitytransport.core.model.document.CIOT;
import com.pwzt.ifsul.splitytransport.core.model.document.CTe;
import com.pwzt.ifsul.splitytransport.core.model.states.TransporteStatus;
import com.pwzt.ifsul.splitytransport.core.model.converter.TransporteStatusConverter;
import com.pwzt.ifsul.splitytransport.core.model.states.TsRascunho;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "GBL_TRA")
@Entity

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Transporte {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRA_CODIGO")
    private Long id;

    @Convert(converter = TransporteStatusConverter.class)
    @Column(name = "TRA_STATUS")
    private TransporteStatus transporteStatus;

    @Column(name = "TRA_DHEMISSA")
    private LocalDateTime dataHoraEmissao;

    @Column(name = "TRA_DHINICIO")
    private LocalDateTime dataHoraInicio;

    @Column(name = "TRA_DHTERMINO")
    private LocalDateTime dataHoraTermino;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "TRA_MOTORISTA", referencedColumnName = "MOT_ID")
    private Motorista motorista;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "TRA_VEICULO", referencedColumnName = "VEI_ID")
    private Veiculo veiculo;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "TRA_CTE", referencedColumnName = "DOC_ID")
    private CTe cte;

    /*@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "TRA_CIOT", referencedColumnName = "DOC_ID")
    private CIOT ciot;*/

    public Transporte(Motorista motorista, Veiculo veiculo){
        this.transporteStatus = new TsRascunho();
        this.motorista = motorista;
        this.veiculo = veiculo;
        this.dataHoraEmissao = LocalDateTime.now();
        this.cte = DocumentoFactory.createDocRascunho(CTe.class);
        //this.ciot = DocumentoFactory.createDocRascunho(CIOT.class);
    }

}
