package com.pwzt.ifsul.splitytransport.api.service;

import com.pwzt.ifsul.splitytransport.api.dto.request.cadastro.FilialDTO;
import com.pwzt.ifsul.splitytransport.api.dto.request.cadastro.MotoristaDTO;
import com.pwzt.ifsul.splitytransport.api.dto.request.cadastro.VeiculoDTO;
import com.pwzt.ifsul.splitytransport.api.dto.response.ResponseApi;
import com.pwzt.ifsul.splitytransport.api.dto.response.ResponseFactory;
import com.pwzt.ifsul.splitytransport.api.repository.InjectionProvider;
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
        InjectionProvider.getMotoristaReposotory().save(motorista);

        // adicionar comunicação com mock da antt para obter número RNTR,
        // retornar junto com o cadastro o rntr

        // só salvar cadastro se retorno 200 da antt
        // usado para validar emissão de ciot, {motorista não cadastrado}

        return ResponseFactory.cadastroSucesso("200", new Pair<>("100", "Motorista cadastrado com sucesso"));
    }

    public ResponseApi cadastrarVeiculo(VeiculoDTO veiculoDTO){
        Veiculo veiculo = objectMapper.convertValue(veiculoDTO, Veiculo.class);
        InjectionProvider.getVeiculoRepository().save(veiculo);

        // adicionar comunicação com mock da antt para vincular veiculo ao rntr do motorista
        // só salvar cadastro se retorno 200 da antt {motorista já cadastrado com rntr}

        return ResponseFactory.cadastroSucesso("200", new Pair<>("100", "Veiculo cadastrado com sucesso"));
    }

    public ResponseApi cadastrarFilial(FilialDTO filialDTO){
        Filial filial = objectMapper.convertValue(filialDTO, Filial.class);
        InjectionProvider.getFilialRepository().save(filial);

        // sem burocracia, pequenas validações

        return ResponseFactory.cadastroSucesso("200", new Pair<>("100", "Filial cadastrada com sucesso"));
    }

}
