package com.pwzt.ifsul.splitytransport.core.configuration;

import com.pwzt.ifsul.splitytransport.core.validation.transporte.CoerenciaValidatorHandler;
import com.pwzt.ifsul.splitytransport.core.validation.transporte.StatusValidatorHandler;
import com.pwzt.ifsul.splitytransport.core.validation.transporte.TransporteValidationHandler;
import com.pwzt.ifsul.splitytransport.core.validation.transporte.ValidadeValidatorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TransporteValidationConfig {

    @Bean
    public TransporteValidationHandler transporteValidationChain(
            CoerenciaValidatorHandler coerenciaValidatorHandler,
            StatusValidatorHandler statusValidatorHandler,
            ValidadeValidatorHandler validadeValidatorHandler
    ){
        coerenciaValidatorHandler.setProximo(statusValidatorHandler);
        statusValidatorHandler.setProximo(validadeValidatorHandler);

        return coerenciaValidatorHandler;
    }

}
