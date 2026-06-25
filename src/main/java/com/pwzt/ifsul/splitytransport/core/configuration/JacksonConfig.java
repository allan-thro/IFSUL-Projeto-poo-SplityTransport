package com.pwzt.ifsul.splitytransport.core.configuration;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.io.IOException;
import java.math.BigDecimal;

@Configuration
public class JacksonConfig {

    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();

        SimpleModule module = new SimpleModule();

        module.addDeserializer(BigDecimal.class, new JsonDeserializer<>() {
            @Override
            public BigDecimal deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
                String valorTexto = p.getText();
                if (valorTexto == null || valorTexto.isBlank()) {
                    return null;
                }

                return new BigDecimal(valorTexto.trim());
            }
        });

        objectMapper.registerModule(module);
        return objectMapper;
    }
}