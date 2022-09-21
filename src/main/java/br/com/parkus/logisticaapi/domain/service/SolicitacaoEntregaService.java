package br.com.parkus.logisticaapi.domain.service;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.parkus.logisticaapi.domain.model.Cliente;
import br.com.parkus.logisticaapi.domain.model.Entrega;
import br.com.parkus.logisticaapi.domain.model.StatusEntrega;
import br.com.parkus.logisticaapi.domain.repository.EntregaRepository;

@Service
public class SolicitacaoEntregaService {
    
    private EntregaRepository entregaRepository;
    private CatalogoClienteService catalogoClienteService;

    public SolicitacaoEntregaService(EntregaRepository entregaRepository, CatalogoClienteService catalogoClienteService) {
        this.entregaRepository = entregaRepository;
        this.catalogoClienteService = catalogoClienteService;
    }

    @Transactional
    public Entrega solicitar(Entrega entrega) {
        Cliente cliente = catalogoClienteService.buscar(entrega.getCliente().getId());

        entrega.setCliente(cliente);
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(OffsetDateTime.now());

        return entregaRepository.save(entrega);
    }

}
