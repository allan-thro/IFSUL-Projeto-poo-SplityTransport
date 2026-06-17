package com.pwzt.ifsul.splitytransport.api.service;

import com.pwzt.ifsul.splitytransport.api.dto.response.ResponseApi;
import com.pwzt.ifsul.splitytransport.core.factory.ResponseFactory;
import com.pwzt.ifsul.splitytransport.api.repository.InjectionProvider;
import com.pwzt.ifsul.splitytransport.core.exception.TransporteValidationException;
import com.pwzt.ifsul.splitytransport.core.model.base.Motorista;
import com.pwzt.ifsul.splitytransport.core.model.base.Transporte;
import com.pwzt.ifsul.splitytransport.core.model.base.Veiculo;
import com.pwzt.ifsul.splitytransport.core.utils.Pair;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.Optional;

@Service
public class TransporteService {

    ObjectMapper objectMapper = new ObjectMapper();

    public ResponseApi cadastrarTransporte(String cpf, String placa){
        Optional<Motorista> motoristaOpt = Optional.ofNullable(InjectionProvider.getMotoristaReposotory().findByCpf(cpf));
        Optional<Veiculo> veiculoOpt = Optional.ofNullable(InjectionProvider.getVeiculoRepository().findByPlaca(placa));

        if(motoristaOpt.isEmpty()) throw new TransporteValidationException("Motorista não cadastrado na base de dados, cadastre o motorista primeiro");
        if(veiculoOpt.isEmpty()) throw new TransporteValidationException("Veiculo não cadastrado na base de dados, cadastre o motorista primeiro");

        Transporte transporte = new Transporte(motoristaOpt.get(), veiculoOpt.get());
        InjectionProvider.getTransporteRepository().save(transporte);

        return ResponseFactory.cadastroSucesso("200", "Transporte cadastrado com sucesso");
    }

}


