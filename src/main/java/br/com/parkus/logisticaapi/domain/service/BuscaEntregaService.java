package br.com.parkus.logisticaapi.domain.service;

import org.springframework.stereotype.Service;

import br.com.parkus.logisticaapi.domain.exception.EntidadeNaoEncontradaException;
import br.com.parkus.logisticaapi.domain.model.Entrega;
import br.com.parkus.logisticaapi.domain.repository.EntregaRepository;

@Service
public class BuscaEntregaService {

    private EntregaRepository entregaRepository;

    public BuscaEntregaService(EntregaRepository entregaRepository) {
        this.entregaRepository = entregaRepository;
    }

    public Entrega buscar(Long entregaId) {
        return entregaRepository.findById(entregaId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada"));
    }
}
