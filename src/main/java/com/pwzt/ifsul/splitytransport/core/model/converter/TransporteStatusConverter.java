package com.pwzt.ifsul.splitytransport.core.model.converter;

import com.pwzt.ifsul.splitytransport.core.model.enumerator.TransporteStatusEnum;
import com.pwzt.ifsul.splitytransport.core.model.states.TransporteStatus;
import com.pwzt.ifsul.splitytransport.core.model.states.TsRascunho;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class TransporteStatusConverter implements AttributeConverter<TransporteStatus, String> {
    @Override
    public String convertToDatabaseColumn(TransporteStatus transporteStatus) {
        if(transporteStatus instanceof TsRascunho) return TransporteStatusEnum.RASCUNHO.getCodigo();

        throw new IllegalArgumentException("Status do transporte inválido");
    }

    @Override
    public TransporteStatus convertToEntityAttribute(String dbData) {
        if(dbData == null) return null;

        switch (TransporteStatusEnum.fromCodigo(dbData)){
            case RASCUNHO:
                return new TsRascunho();
        }

        throw new IllegalArgumentException("Status do transporte inválido");
    }
}
