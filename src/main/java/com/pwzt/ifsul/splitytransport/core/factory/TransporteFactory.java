package com.pwzt.ifsul.splitytransport.core.factory;

import com.pwzt.ifsul.splitytransport.core.model.base.Transporte;
import com.pwzt.ifsul.splitytransport.core.model.document.CIOT;
import com.pwzt.ifsul.splitytransport.core.model.document.CTe;
import com.pwzt.ifsul.splitytransport.core.model.states.TsRascunho;

import java.time.LocalDateTime;

public class TransporteFactory {

    public static Transporte createNovoTransporte(){
        Transporte transporte = new Transporte();

        transporte.setTransporteStatus(new TsRascunho());
        transporte.setCte(DocumentoFactory.createDocRascunho(CTe.class));
        transporte.setCiot(DocumentoFactory.createDocRascunho(CIOT.class));
        transporte.setDataHoraEmissao(LocalDateTime.now());

        return transporte;
    }

}
