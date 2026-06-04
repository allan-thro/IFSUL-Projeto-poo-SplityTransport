package com.pwzt.ifsul.splitytransport.api.repository;

import com.pwzt.ifsul.splitytransport.core.model.base.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByCpfCnpj(String cpfCnpj);

}
