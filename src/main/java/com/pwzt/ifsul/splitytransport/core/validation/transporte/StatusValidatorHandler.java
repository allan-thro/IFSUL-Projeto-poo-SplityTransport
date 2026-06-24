package com.pwzt.ifsul.splitytransport.core.validation.transporte;

import com.pwzt.ifsul.splitytransport.api.dto.response.ResponseMensagem;
import com.pwzt.ifsul.splitytransport.core.model.base.Transporte;
import com.pwzt.ifsul.splitytransport.core.model.states.DsAutorizado;
import com.pwzt.ifsul.splitytransport.core.validation.ValidationResult;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StatusValidatorHandler extends TransporteValidationHandler{

    @Override
    protected ValidationResult validar(Transporte transporte) {
        List<ResponseMensagem> erros = new ArrayList<>();

        if(!(transporte.getCte().getStatus() instanceof DsAutorizado)){
            erros.add(new ResponseMensagem.Builder()
                    .codigo("105")
                    .descricao("CTe não autorizado, impossivel iniciar a viajem")
                    .erro()
                    .build()
            );
        }

        if(!transporte.getTransporteStatus().podeAutorizar()){
            erros.add(new ResponseMensagem.Builder()
                    .codigo("105")
                    .descricao(String.format("Transição de estado invalida, %s não pode ser iniciado",
                            transporte.getTransporteStatus().estadoAtual().getDescricao()))
                    .erro()
                    .build()
            );
        }

        return new ValidationResult(erros);
    }

}
