package com.pwzt.ifsul.splitytransport.core.factory;

import com.pwzt.ifsul.splitytransport.api.dto.response.ResponseMensagem;
import com.pwzt.ifsul.splitytransport.api.repository.InjectionProvider;
import com.pwzt.ifsul.splitytransport.core.exception.TransporteValidationException;
import com.pwzt.ifsul.splitytransport.core.model.base.Motorista;
import com.pwzt.ifsul.splitytransport.core.model.base.Transporte;
import com.pwzt.ifsul.splitytransport.core.model.base.Veiculo;
import com.pwzt.ifsul.splitytransport.core.model.document.CIOT;
import com.pwzt.ifsul.splitytransport.core.model.document.CTe;
import com.pwzt.ifsul.splitytransport.core.model.states.TsRascunho;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TransporteFactory {

    public static Transporte createNovoTransporte(String cpf, String placa){
        Optional<Motorista> motoristaOpt = Optional.ofNullable(InjectionProvider.getMotoristaReposotory().findByCpf(cpf));
        Optional<Veiculo> veiculoOpt = Optional.ofNullable(InjectionProvider.getVeiculoRepository().findByPlaca(placa));
        List<ResponseMensagem> erroList = new ArrayList<>();

        if(motoristaOpt.isEmpty()){
            ResponseMensagem message = new ResponseMensagem.Builder()
                    .descricao("Motorista não cadastrado na base de dados, cadastre o motorista primeiro")
                    .codigo("404")
                    .erro()
                    .build();

            erroList.add(message);
        }
        if(veiculoOpt.isEmpty()){
            ResponseMensagem message = new ResponseMensagem.Builder()
                    .descricao("Veiculo não cadastrado na base de dados, cadastre o motorista primeiro")
                    .codigo("404")
                    .erro()
                    .build();

            erroList.add(message);
        }

        if(!erroList.isEmpty()) throw new TransporteValidationException("Não foi possivel criar novo transporte", erroList);

        Transporte transporte = new Transporte();

        transporte.setCte(DocumentoFactory.createDocRascunho(CTe.class));
        transporte.setDataHoraEmissao(LocalDateTime.now());
        transporte.setTransporteStatus(new TsRascunho());
        transporte.setMotorista(motoristaOpt.get());
        transporte.setVeiculo(veiculoOpt.get());

        return transporte;
    }

}
