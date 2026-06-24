package com.pwzt.ifsul.splitytransport.core.validation.transporte;

import com.pwzt.ifsul.splitytransport.api.dto.response.ResponseMensagem;
import com.pwzt.ifsul.splitytransport.core.model.base.Transporte;
import com.pwzt.ifsul.splitytransport.core.validation.ValidationResult;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class ValidadeValidatorHandler extends TransporteValidationHandler{

    @Override
    protected ValidationResult validar(Transporte transporte) {
        List<ResponseMensagem> erros = new ArrayList<>();

        if(transporte.getMotorista().getValidadeCnh().isAfter(LocalDate.now())){
            erros.add(
                    new ResponseMensagem.Builder()
                            .descricao("Validade da CNH do motorista está vencia")
                            .codigo("150")
                            .erro()
                            .build()
            );
        }

        if(transporte.getMotorista().getValidadeRntrc().isAfter(LocalDate.now())){
            erros.add(
                    new ResponseMensagem.Builder()
                            .descricao("Validade do Rntrc do motorista está vencica")
                            .codigo("150")
                            .erro()
                            .build()
            );
        }

        return new ValidationResult(erros);
    }

}
