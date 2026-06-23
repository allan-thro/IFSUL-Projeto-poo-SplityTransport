package com.pwzt.ifsul.splitytransport.core.validation.transporte;

import com.pwzt.ifsul.splitytransport.api.dto.response.ResponseMensagem;
import com.pwzt.ifsul.splitytransport.core.model.base.Transporte;
import com.pwzt.ifsul.splitytransport.core.validation.ValidationResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CoerenciaValidatorHandler extends TransporteValidationHandler{

    @Override
    protected ValidationResult validar(Transporte transporte) {
        List<ResponseMensagem> erros = new ArrayList<>();

        if(transporte.getCte().getPesoCarga().compareTo(transporte.getVeiculo().getCapacidadeMaxima()) > 0){
            erros.add(
                    new ResponseMensagem.Builder()
                            .descricao("Peso da carga informada no CTe excede capacidade maxima do veiculo atribuido para viagem")
                            .codigo("305")
                            .erro()
                            .build()
            );
        }

        if(!Objects.equals(transporte.getVeiculo().getRntrc(), transporte.getMotorista().getRNTRC())){
            erros.add(
                    new ResponseMensagem.Builder()
                            .descricao("Rntrc do proprietário cadastrado do veiculo é diferente do rntrc do motorista, utilize o mesmo rntc para veiculo e motorista")
                            .codigo("305")
                            .erro()
                            .build()
            );
        }

        return new ValidationResult(erros);
    }

}
