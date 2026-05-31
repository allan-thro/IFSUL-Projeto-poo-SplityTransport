package com.pwzt.ifsul.splitytransport.api.repository;

import com.pwzt.ifsul.splitytransport.core.model.base.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    Veiculo findByPlaca(String placa);

}
