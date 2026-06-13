package com.pwzt.ifsul.splitytransport.api.service;


public interface DocumentoService<T, R> {
    R emitir(T dto, Long transportId);
    R consultar(String chave);
    R cancelar(String chave, String motivo);
}
