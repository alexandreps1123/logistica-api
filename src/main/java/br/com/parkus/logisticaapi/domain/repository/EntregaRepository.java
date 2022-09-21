package br.com.parkus.logisticaapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.parkus.logisticaapi.domain.model.Entrega;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long> {
    
}
