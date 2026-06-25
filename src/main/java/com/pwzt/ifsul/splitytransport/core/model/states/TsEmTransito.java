package com.pwzt.ifsul.splitytransport.core.model.states;

import com.pwzt.ifsul.splitytransport.api.dto.response.ResponseMensagem;
import com.pwzt.ifsul.splitytransport.core.exception.DocumentoValidationException;
import com.pwzt.ifsul.splitytransport.core.model.base.Transporte;
import com.pwzt.ifsul.splitytransport.core.model.enumerator.TransporteStatusEnum;

public class TsEmTransito implements TransporteStatus{

    @Override
    public TransporteStatusEnum estadoAtual() {
        return TransporteStatusEnum.EM_TRANSITO;
    }

    @Override
    public boolean podeAutorizar() {
        return false;
    }

    @Override
    public boolean podeIniciar() {
        return false;
    }

    @Override
    public void autorizar(Transporte transporte) {
        throw new DocumentoValidationException("Erro ao alterar estado", gerarMensagemErro());
    }

    @Override
    public void iniciar(Transporte transporte) {
        transporte.setTransporteStatus(new TsEmTransito());
    }

    @Override
    public void concluir(Transporte transporte) {
        transporte.setTransporteStatus(new TsEntregue());
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
