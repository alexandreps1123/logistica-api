package br.com.parkus.logisticaapi.domain.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.parkus.logisticaapi.domain.model.Entrega;
import br.com.parkus.logisticaapi.domain.model.Ocorrencia;

@Service
public class RegistroOcorrenciaServive {

    private BuscaEntregaService buscaEntregaService;

    public RegistroOcorrenciaServive(BuscaEntregaService buscaEntregaService) {
        this.buscaEntregaService = buscaEntregaService;
    }

    @Transactional
    public Ocorrencia registrar(Long entregaId, String descricao) {
        Entrega entrega = buscaEntregaService.buscar(entregaId);

        return entrega.adicionarOcorrencia(descricao);
    }
}
