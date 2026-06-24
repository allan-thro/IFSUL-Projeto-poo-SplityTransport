package com.pwzt.ifsul.splitytransport.core.factory;

import com.pwzt.ifsul.splitytransport.core.exception.DocumentoValidationException;
import com.pwzt.ifsul.splitytransport.core.model.document.Documento;
import com.pwzt.ifsul.splitytransport.core.model.enumerator.DocStatusEnum;

public class DocumentoFactory {

    public static <T extends Documento> T createDocRascunho(Class<T> classe){
        try{
            T documento = classe.getDeclaredConstructor().newInstance();
            documento.setStatus(DocStatusEnum.RASCUNHO);

            return documento;
        }catch (Exception e){
            throw new DocumentoValidationException("Erro ao criar novo documento");
        }
    }

}
