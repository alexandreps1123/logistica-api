package br.com.parkus.logisticaapi.domain.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.parkus.logisticaapi.domain.model.Entrega;
import br.com.parkus.logisticaapi.domain.repository.EntregaRepository;

@Service
public class FinalizacaoEntregaService {

    private EntregaRepository entregaRepository;
    private BuscaEntregaService buscaEntregaService;

    public FinalizacaoEntregaService(EntregaRepository entregaRepository, BuscaEntregaService buscaEntregaService) {
        this.entregaRepository = entregaRepository;
        this.buscaEntregaService = buscaEntregaService;
    }

    @Transactional
    public void finalizar(Long entregaId) {
        Entrega entrega = buscaEntregaService.buscar(entregaId);

        entrega.finalizar();

        entregaRepository.save(entrega);
    }
}
