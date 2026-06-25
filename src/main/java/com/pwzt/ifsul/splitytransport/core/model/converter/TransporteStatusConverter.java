package com.pwzt.ifsul.splitytransport.core.model.converter;

import com.pwzt.ifsul.splitytransport.core.model.enumerator.TransporteStatusEnum;
import com.pwzt.ifsul.splitytransport.core.model.states.*;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class TransporteStatusConverter implements AttributeConverter<TransporteStatus, String> {
    @Override
    public String convertToDatabaseColumn(TransporteStatus transporteStatus) {
        if(transporteStatus instanceof TsCancelado) return TransporteStatusEnum.CANCELADO.getDescricao();
        if(transporteStatus instanceof TsDocumentoAutorizado) return TransporteStatusEnum.DOCUMENTOS_AUTORIZADOS.getDescricao();
        if(transporteStatus instanceof TsEmTransito) return TransporteStatusEnum.EM_TRANSITO.getDescricao();
        if(transporteStatus instanceof TsEntregue) return TransporteStatusEnum.ENTREGUE.getDescricao();
        if(transporteStatus instanceof TsRascunho) return TransporteStatusEnum.RASCUNHO.getDescricao();

        throw new IllegalArgumentException("Status do transporte inválido");
    }

    @Override
    public TransporteStatus convertToEntityAttribute(String dbData) {
        if(dbData == null) return null;

        switch (TransporteStatusEnum.fromCodigo(dbData)){
            case CANCELADO:
                return new TsCancelado();
            case DOCUMENTOS_AUTORIZADOS:
                return new TsDocumentoAutorizado();
            case EM_TRANSITO:
                return new TsEmTransito();
            case ENTREGUE:
                return new TsEntregue();
            case RASCUNHO:
                return new TsRascunho();
        }

        throw new IllegalArgumentException("Status do transporte inválido");
    }
}
