package com.pwzt.ifsul.splitytransport.api.service;

import com.pwzt.ifsul.splitytransport.api.dto.request.cadastro.FilialDTO;
import com.pwzt.ifsul.splitytransport.api.dto.request.cadastro.MotoristaDTO;
import com.pwzt.ifsul.splitytransport.api.dto.request.cadastro.VeiculoDTO;
import com.pwzt.ifsul.splitytransport.api.dto.response.Mensagem;
import com.pwzt.ifsul.splitytransport.api.dto.response.ResponseApi;
import com.pwzt.ifsul.splitytransport.api.dto.response.cadastro.ResponseCadastroMotoristaAntt;
import com.pwzt.ifsul.splitytransport.core.exception.ComunicationException;
import com.pwzt.ifsul.splitytransport.core.factory.ResponseFactory;
import com.pwzt.ifsul.splitytransport.api.repository.InjectionProvider;
import com.pwzt.ifsul.splitytransport.core.model.base.Filial;
import com.pwzt.ifsul.splitytransport.core.model.base.Motorista;
import com.pwzt.ifsul.splitytransport.core.model.base.Veiculo;
import com.pwzt.ifsul.splitytransport.core.utils.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import tools.jackson.databind.ObjectMapper;

import java.util.ArrayList;

@Service

public class CadastroService {

    private final String ANTT_MOCK_URL = "https://localhost:8085/api/antt/cadastro";

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final RestTemplate restTemplate = new RestTemplate();

    public ResponseApi cadastrarMotorista(MotoristaDTO motoristaDTO){
        Motorista motorista = objectMapper.convertValue(motoristaDTO, Motorista.class);
        String urlMock = UriComponentsBuilder.fromPath(ANTT_MOCK_URL)
                .path("/motorista")
                .queryParam("cpf", motoristaDTO.getCpf())
                .queryParam("nome", motorista.getNome())
                .encode()
                .toUriString();

        try{
            ResponseCadastroMotoristaAntt response = restTemplate.postForObject(urlMock, null, ResponseCadastroMotoristaAntt.class);

            if(response.getCodigoStatusAntt().equals("100")){
                motorista.setRNTRC(response.getRntrc());
                InjectionProvider.getMotoristaReposotory().save(motorista);
            }

            return ResponseFactory.cadastroMotoristaAntt(response);
        }
        catch (Exception e) {
            throw new ComunicationException(e.getMessage());
        }
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
