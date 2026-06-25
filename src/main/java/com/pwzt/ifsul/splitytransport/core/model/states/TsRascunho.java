package com.pwzt.ifsul.splitytransport.core.model.states;

import com.pwzt.ifsul.splitytransport.api.dto.response.ResponseMensagem;
import com.pwzt.ifsul.splitytransport.core.exception.DocumentoValidationException;
import com.pwzt.ifsul.splitytransport.core.model.base.Transporte;
import com.pwzt.ifsul.splitytransport.core.model.enumerator.TransporteStatusEnum;

public class TsRascunho implements TransporteStatus{


    @Override
    public TransporteStatusEnum estadoAtual() {
        return TransporteStatusEnum.RASCUNHO;
    }

    @Override
    public boolean podeAutorizar() {
        return true;
    }

    @Override
    public boolean podeIniciar() {
        return false;
    }

    @Override
    public void autorizar(Transporte transporte) {
        transporte.setTransporteStatus(new TsDocumentoAutorizado());
    }

    @Override
    public void iniciar(Transporte transporte) {
        throw new DocumentoValidationException("Erro ao alterar estado", gerarMensagemErro());
    }

    @Override
    public void concluir(Transporte transporte) {
        throw new DocumentoValidationException("Erro ao alterar estado", gerarMensagemErro());
    }

    @Override
    public void cancelar(Transporte transporte) {
        throw new DocumentoValidationException("Erro ao alterar estado", gerarMensagemErro());
    }

    private ResponseMensagem gerarMensagemErro(){
        return new ResponseMensagem.Builder()
                .descricao(String.format("Transição de estado inválida, %s não pode ser iniciado", estadoAtual().getDescricao()))
                .codigo("400")
                .erro()
                .build();
    }

}
