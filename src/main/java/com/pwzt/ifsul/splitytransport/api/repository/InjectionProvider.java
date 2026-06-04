package com.pwzt.ifsul.splitytransport.api.repository;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class InjectionProvider {

    @Autowired
    private MotoristaReposotory motoristaReposotoryInject;

    @Autowired
    private VeiculoRepository veiculoRepositoryInject;

    @Autowired
    private FilialRepository filialRepositoryInject;

    @Autowired
    private TransporteRepository transporteRepositoryInject;

    @Autowired
    private ClienteRepository clienteRepositoryInject;

    @Autowired
    private CTeReposotory cteReposotoryInject;

    @Getter private static ClienteRepository clienteRepository;
    @Getter private static TransporteRepository transporteRepository;
    @Getter private static MotoristaReposotory motoristaReposotory;
    @Getter private static VeiculoRepository veiculoRepository;
    @Getter private static FilialRepository filialRepository;
    @Getter private static CTeReposotory cteReposotory;

    @PostConstruct
    public void init(){
        InjectionProvider.filialRepository = this.filialRepositoryInject;
        InjectionProvider.veiculoRepository = this.veiculoRepositoryInject;
        InjectionProvider.motoristaReposotory = this.motoristaReposotoryInject;
        InjectionProvider.transporteRepository = this.transporteRepositoryInject;
        InjectionProvider.clienteRepository = this.clienteRepositoryInject;
        InjectionProvider.cteReposotory = this.cteReposotoryInject;
    }

}
