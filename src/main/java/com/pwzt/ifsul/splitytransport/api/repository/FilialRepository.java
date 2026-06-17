package com.pwzt.ifsul.splitytransport.api.repository;

import com.pwzt.ifsul.splitytransport.core.model.base.Filial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FilialRepository extends JpaRepository<Filial, Long> {

    Optional<Filial> findByCnpj(String cnpj);

}
