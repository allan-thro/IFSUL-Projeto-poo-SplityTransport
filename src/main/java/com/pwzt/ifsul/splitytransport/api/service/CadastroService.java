package com.pwzt.ifsul.splitytransport.api.service;

import com.pwzt.ifsul.splitytransport.api.dto.request.cadastro.FilialDTO;
import com.pwzt.ifsul.splitytransport.api.dto.request.cadastro.MotoristaDTO;
import com.pwzt.ifsul.splitytransport.api.dto.request.cadastro.VeiculoDTO;
import com.pwzt.ifsul.splitytransport.api.dto.response.ResponseApi;
import com.pwzt.ifsul.splitytransport.api.dto.response.ResponseFactory;
import com.pwzt.ifsul.splitytransport.api.repository.RepositoryFactory;
import com.pwzt.ifsul.splitytransport.core.model.base.Filial;
import com.pwzt.ifsul.splitytransport.core.model.base.Motorista;
import com.pwzt.ifsul.splitytransport.core.model.base.Veiculo;
import com.pwzt.ifsul.splitytransport.core.utils.Pair;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@Service
public class CadastroService {

    ObjectMapper objectMapper = new ObjectMapper();

    public ResponseApi cadastrarMotorista(MotoristaDTO motoristaDTO){
        Motorista motorista = objectMapper.convertValue(motoristaDTO, Motorista.class);
        RepositoryFactory.getMotoristaReposotory().save(motorista);

        return ResponseFactory.cadastroSucesso("200", new Pair<>("100", "Motorista cadastrado com sucesso"));
    }

    public ResponseApi cadastrarVeiculo(VeiculoDTO veiculoDTO){
        Veiculo veiculo = objectMapper.convertValue(veiculoDTO, Veiculo.class);
        RepositoryFactory.getVeiculoRepository().save(veiculo);

        return ResponseFactory.cadastroSucesso("200", new Pair<>("100", "Veiculo cadastrado com sucesso"));
    }

    public ResponseApi cadastrarFilial(FilialDTO filialDTO){
        Filial filial = objectMapper.convertValue(filialDTO, Filial.class);
        RepositoryFactory.getFilialRepository().save(filial);

        return ResponseFactory.cadastroSucesso("200", new Pair<>("100", "Filial cadastrada com sucesso"));
    }

}
