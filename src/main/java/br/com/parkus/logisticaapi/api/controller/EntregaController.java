package br.com.parkus.logisticaapi.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.parkus.logisticaapi.api.mapper.EntregaMapper;
import br.com.parkus.logisticaapi.api.model.request.EntregaRequest;
import br.com.parkus.logisticaapi.api.model.response.EntregaResponse;
import br.com.parkus.logisticaapi.domain.model.Entrega;
import br.com.parkus.logisticaapi.domain.repository.EntregaRepository;
import br.com.parkus.logisticaapi.domain.service.FinalizacaoEntregaService;
import br.com.parkus.logisticaapi.domain.service.SolicitacaoEntregaService;

@RestController
@RequestMapping("/entregas")
public class EntregaController {
    
    private SolicitacaoEntregaService solicitacaoEntregaService;
    private FinalizacaoEntregaService finalizacaoEntregaService;
    private EntregaRepository entregaRepository;
    private EntregaMapper entregaMapper;

    public EntregaController(SolicitacaoEntregaService solicitacaoEntregaService, EntregaRepository entregaRepository,
                                EntregaMapper entregaMapper, FinalizacaoEntregaService finalizacaoEntregaService) {
        this.solicitacaoEntregaService = solicitacaoEntregaService;
        this.entregaRepository = entregaRepository;
        this.entregaMapper = entregaMapper;
        this.finalizacaoEntregaService = finalizacaoEntregaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntregaResponse solicitar(@Valid @RequestBody EntregaRequest entregaRequest) {
        Entrega novaEntrega = entregaMapper.fromEntregaRequest(entregaRequest);

        Entrega entregaSolicitada = solicitacaoEntregaService.solicitar(novaEntrega);
        return entregaMapper.toEntregaResponse(entregaSolicitada);
    }
    
    @GetMapping
    public List<EntregaResponse> listar() {
        return entregaMapper.toCollectionEntregaResponse(entregaRepository.findAll());
    }

    @GetMapping("/{entregaId}")
    public ResponseEntity<EntregaResponse> buscar(@PathVariable Long entregaId) {
        return entregaRepository.findById(entregaId)
                .map(entrega -> ResponseEntity.ok(entregaMapper.toEntregaResponse(entrega)))
                    // EntregaResponse entregaResponse = new EntregaResponse();

                    // entregaResponse.setId(entrega.getId());
                    // entregaResponse.setNomeCliente(entrega.getCliente().getNome());
                    // entregaResponse.setDestinatario(new DestinatarioResponse());
                    // entregaResponse.getDestinatario().setNome(entrega.getDestinatario().getNome());
                    // entregaResponse.getDestinatario().setLogradouro(entrega.getDestinatario().getLogradouro());
                    // entregaResponse.getDestinatario().setBairro(entrega.getDestinatario().getBairro());
                    // entregaResponse.getDestinatario().setNumero(entrega.getDestinatario().getNumero());
                    // entregaResponse.getDestinatario().setComplemento(entrega.getDestinatario().getComplemento());
                    // entregaResponse.setTaxa(entrega.getTaxa());
                    // entregaResponse.setStatus(entrega.getStatus());
                    // entregaResponse.setDataPedido(entrega.getDataPedido());
                    // entregaResponse.setDataFinalizacao(entrega.getDataFinalizacao());

                    
                .orElse(ResponseEntity.notFound().build()); 
    }

    @PutMapping("/{entregaId}/finalizacao")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void finalizar(@PathVariable Long entregaId) {
        finalizacaoEntregaService.finalizar(entregaId);
    }

}
