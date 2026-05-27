package com.pwzt.ifsul.splitytransport.core.model.states;

import com.pwzt.ifsul.splitytransport.core.model.enumerator.DocStatusEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = false)
public class DocStatusConverter implements AttributeConverter<DocStatus, String> {

    @Override
    public String convertToDatabaseColumn(DocStatus docStatus){
        if(docStatus instanceof DsAutorizado) return DocStatusEnum.AUTORIZADO.getCodigo();
        if(docStatus instanceof DsCancelado) return DocStatusEnum.CANCELADO.getCodigo();
        if(docStatus instanceof DsDenegado) return DocStatusEnum.DENEGADO.getCodigo();
        if(docStatus instanceof DsPendente) return DocStatusEnum.PENDENTE.getCodigo();
        if(docStatus instanceof DsRascunho) return DocStatusEnum.RASCUNHO.getCodigo();
        if(docStatus instanceof DsRejeitado) return DocStatusEnum.REJEITADO.getCodigo();
        throw new IllegalArgumentException("Status do documento inválido");
    }

    @Override
    public DocStatus convertToEntityAttribute(String dbData){
        if(dbData == null) return null;

        switch (DocStatusEnum.fromCodigo(dbData)){
            case AUTORIZADO:
                return new DsAutorizado();
            case CANCELADO:
                return new DsCancelado();
            case DENEGADO:
                return new DsDenegado();
            case PENDENTE:
                return new DsPendente();
            case RASCUNHO:
                return new DsRascunho();
            case REJEITADO:
                return new DsRejeitado();
        }

        throw new IllegalArgumentException("Status Doc inválido");
    }

}
