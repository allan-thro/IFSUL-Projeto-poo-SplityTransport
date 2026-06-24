package com.pwzt.ifsul.splitytransport.api.service;

import com.pwzt.ifsul.splitytransport.api.dto.request.cadastro.FilialDTO;
import com.pwzt.ifsul.splitytransport.api.dto.request.cadastro.MotoristaDTO;
import com.pwzt.ifsul.splitytransport.api.dto.request.cadastro.VeiculoDTO;
import com.pwzt.ifsul.splitytransport.api.dto.response.ResponseApi;
import com.pwzt.ifsul.splitytransport.api.dto.response.ResponseMensagem;
import com.pwzt.ifsul.splitytransport.api.dto.response.cadastro.ResponseCadastroMotoristaAntt;
import com.pwzt.ifsul.splitytransport.api.dto.response.cadastro.ResponseCadastroVeiculoAntt;
import com.pwzt.ifsul.splitytransport.api.repository.InjectionProvider;
import com.pwzt.ifsul.splitytransport.core.exception.ComunicationException;
import com.pwzt.ifsul.splitytransport.core.factory.ResponseFactory;
import com.pwzt.ifsul.splitytransport.core.model.base.Filial;
import com.pwzt.ifsul.splitytransport.core.model.base.Motorista;
import com.pwzt.ifsul.splitytransport.core.model.base.Veiculo;
import jakarta.validation.ValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import tools.jackson.databind.ObjectMapper;

@Service

public class CadastroService {

    private final String ANTT_MOCK_URL = "https://localhost:8085/api/antt/cadastro";

    private final RestClient restClient = RestClient.builder().build();

    private final ObjectMapper objectMapper = new ObjectMapper();


    public ResponseApi cadastrarMotorista(MotoristaDTO motoristaDTO){
        Motorista motorista = objectMapper.convertValue(motoristaDTO, Motorista.class);
        String urlMock = UriComponentsBuilder.fromPath(ANTT_MOCK_URL)
                .path("/motorista")
                .queryParam("cpf", motoristaDTO.getCpf())
                .queryParam("nome", motorista.getNome())
                .encode()
                .toUriString();

        try{
            ResponseEntity<ResponseCadastroMotoristaAntt> response = restClient.get()
                    .uri(urlMock)
                    .retrieve()
                    .toEntity(ResponseCadastroMotoristaAntt.class);

            if(response.getBody() != null && response.getBody().getCodigoStatusAntt().equals("100")){
                motorista.setRNTRC(response.getBody().getRntrc());
                InjectionProvider.getMotoristaReposotory().save(motorista);
            }

            return ResponseFactory.createResponseCadastroAntt(response.getBody(), response.getStatusCode().toString());
        } catch (HttpStatusCodeException e){
            ResponseMensagem erro = new ResponseMensagem.Builder()
                    .descricao("Falha ao comunicar com a ANTT.")
                    .codigo(e.getStatusCode().toString())
                    .erro()
                    .build();

            throw new ComunicationException(erro);
        } catch (RestClientException e){
            ResponseMensagem erro = new ResponseMensagem.Builder()
                    .descricao("Não foi possivel conectar com a ANTT.")
                    .codigo("400")
                    .erro()
                    .build();

            throw new ComunicationException(erro);
        }
    }

    public ResponseApi cadastrarVeiculo(VeiculoDTO veiculoDTO){
        Veiculo veiculo = objectMapper.convertValue(veiculoDTO, Veiculo.class);
        String urlMock = UriComponentsBuilder.fromPath(ANTT_MOCK_URL)
                .path("/veiculo")
                .queryParam("placa", veiculoDTO.getPlaca())
                .queryParam("rntrc", veiculoDTO.getRntrc())
                .queryParam("capacidade_maxima", veiculoDTO.getCapacidadeMaxima())
                .encode()
                .toUriString();

        try{
            ResponseEntity<ResponseCadastroVeiculoAntt> response = restClient.get()
                    .uri(urlMock)
                    .retrieve()
                    .toEntity(ResponseCadastroVeiculoAntt.class);

            if(response.getBody() != null && response.getBody().getCodigoStatusAntt().equals("100")){
                InjectionProvider.getVeiculoRepository().save(veiculo);
            }

            return ResponseFactory.createResponseCadastroAntt(response.getBody(), response.getStatusCode().toString());
        } catch (HttpStatusCodeException e){
            ResponseMensagem erro = new ResponseMensagem.Builder()
                    .descricao("Falha ao comunicar com a ANTT.")
                    .codigo(e.getStatusCode().toString())
                    .erro()
                    .build();

            throw new ComunicationException(erro);
        } catch (RestClientException e){
            ResponseMensagem erro = new ResponseMensagem.Builder()
                    .descricao("Não foi possivel conectar com a ANTT.")
                    .codigo("400")
                    .erro()
                    .build();

            throw new ComunicationException(erro);
        }
    }

    public ResponseApi cadastrarFilial(FilialDTO filialDTO){
        Filial filial = objectMapper.convertValue(filialDTO, Filial.class);

        InjectionProvider.getFilialRepository().findByCnpj(filialDTO.getCnpj())
                .orElseThrow(() -> new ValidationException("Cnpj ja cadastrado na base de dados"));

        InjectionProvider.getFilialRepository().save(filial);

        return ResponseFactory.createResponseSucesso("200", "Filial cadastrada com sucesso");
    }

}
