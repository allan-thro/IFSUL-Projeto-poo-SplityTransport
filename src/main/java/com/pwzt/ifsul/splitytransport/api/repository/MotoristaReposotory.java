package com.pwzt.ifsul.splitytransport.api.repository;

import com.pwzt.ifsul.splitytransport.core.model.base.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotoristaReposotory extends JpaRepository<Motorista, Long> {

    Motorista findByCpf(String cpf);

}
