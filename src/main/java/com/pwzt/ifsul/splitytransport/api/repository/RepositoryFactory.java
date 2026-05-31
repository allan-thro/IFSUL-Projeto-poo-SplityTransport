package com.pwzt.ifsul.splitytransport.api.repository;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class RepositoryFactory {

    @Autowired
    private MotoristaReposotory motoristaReposotoryInject;

    @Autowired
    private VeiculoRepository veiculoRepositoryInject;

    @Autowired
    private FilialRepository filialRepositoryInject;


    @Getter private static MotoristaReposotory motoristaReposotory;
    @Getter private static VeiculoRepository veiculoRepository;
    @Getter private static FilialRepository filialRepository;

    @PostConstruct
    public void init(){
        RepositoryFactory.filialRepository = this.filialRepositoryInject;
        RepositoryFactory.veiculoRepository = this.veiculoRepositoryInject;
        RepositoryFactory.motoristaReposotory = this.motoristaReposotoryInject;
    }

}
