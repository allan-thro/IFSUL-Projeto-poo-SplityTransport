package com.pwzt.ifsul.splitytransport.api.service;


import com.pwzt.ifsul.splitytransport.core.model.document.Documento;

public interface DocumentoService<T, R> {
    R emitir(T dto, Long transportId);
    R consultar(String chave);
    R cancelar(String chave, String motivo);
}
