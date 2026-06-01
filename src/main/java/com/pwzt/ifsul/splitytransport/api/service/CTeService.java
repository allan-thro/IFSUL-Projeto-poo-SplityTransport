package com.pwzt.ifsul.splitytransport.api.service;

import com.pwzt.ifsul.splitytransport.api.dto.response.cte.ResponseCTe;
import com.pwzt.ifsul.splitytransport.core.complextype.cte.TcInfCTE;
import com.pwzt.ifsul.splitytransport.core.model.document.CTe;

public class CTeService implements DocumentoService<TcInfCTE, ResponseCTe>{


    @Override
    public ResponseCTe emitir(TcInfCTE json) {
        return null;
    }

    @Override
    public ResponseCTe consultar(String chave) {
        return null;
    }

    @Override
    public ResponseCTe cancelar(String chave, String motivo) {
        return null;
    }
}
