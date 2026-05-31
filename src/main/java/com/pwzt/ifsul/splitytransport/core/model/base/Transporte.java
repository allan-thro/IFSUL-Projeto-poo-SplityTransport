package com.pwzt.ifsul.splitytransport.core.model.base;

import com.pwzt.ifsul.splitytransport.core.model.document.CIOT;
import com.pwzt.ifsul.splitytransport.core.model.document.CTe;
import com.pwzt.ifsul.splitytransport.core.model.document.Documento;
import com.pwzt.ifsul.splitytransport.core.model.states.TransporteStatus;
import com.pwzt.ifsul.splitytransport.core.model.states.TransporteStatusConverter;
import com.pwzt.ifsul.splitytransport.core.model.states.TsRascunho;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "GBL_TRA")
@Entity

@AllArgsConstructor
public class Transporte {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne
    @JoinColumn(name = "MOT_ID")
    @Column(name = "TRA_MOTORISTA")
    private Motorista motorista;

    @ManyToOne
    @JoinColumn(name = "VEI_ID")
    @Column(name = "TRA_VEICULO")
    private Veiculo veiculo;

    @OneToOne
    @JoinColumn(name = "DOC_ID")
    @Column(name = "TRA_CTE")
    private CTe cte;

    @OneToOne
    @JoinColumn(name = "DOC_ID")
    @Column(name = "TRA_CIOT")
    private CIOT ciot;

    public Transporte(Motorista motorista, Veiculo veiculo){
        this.transporteStatus = new TsRascunho();
        this.motorista = motorista;
        this.veiculo = veiculo;
        this.dataHoraEmissao = LocalDateTime.now();
        this.cte = new CTe()
    }

}
