package com.pwzt.ifsul.splitytransport.api.service;

import com.pwzt.ifsul.splitytransport.api.dto.response.ResponseApi;
import com.pwzt.ifsul.splitytransport.api.repository.RepositoryFactory;
import com.pwzt.ifsul.splitytransport.core.TransporteValidationException;
import com.pwzt.ifsul.splitytransport.core.model.base.Motorista;
import com.pwzt.ifsul.splitytransport.core.model.base.Transporte;
import com.pwzt.ifsul.splitytransport.core.model.base.Veiculo;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.Optional;

@Service
public class TransporteService {

    ObjectMapper objectMapper = new ObjectMapper();

    public ResponseApi cadastrarTransporte(String cpf, String placa){
        Optional<Motorista> motoristaOpt = Optional.ofNullable(RepositoryFactory.getMotoristaReposotory().findByCpf(cpf));
        Optional<Veiculo> veiculoOpt = Optional.ofNullable(RepositoryFactory.getVeiculoRepository().findByPlaca(placa));

        if(motoristaOpt.isEmpty()) throw new TransporteValidationException("Motorista não cadastrado na base de dados, cadastre o motorista primeiro");
        if(veiculoOpt.isEmpty()) throw new TransporteValidationException("Veiculo não cadastrado na base de dados, cadastre o motorista primeiro");

        Transporte

    }
}


