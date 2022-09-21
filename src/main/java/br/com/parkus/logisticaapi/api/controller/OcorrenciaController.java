package br.com.parkus.logisticaapi.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.parkus.logisticaapi.api.mapper.OcorrenciaMapper;
import br.com.parkus.logisticaapi.api.model.request.OcorrenciaResquest;
import br.com.parkus.logisticaapi.api.model.response.OcorrenciaResponse;
import br.com.parkus.logisticaapi.domain.model.Entrega;
import br.com.parkus.logisticaapi.domain.model.Ocorrencia;
import br.com.parkus.logisticaapi.domain.service.BuscaEntregaService;
import br.com.parkus.logisticaapi.domain.service.RegistroOcorrenciaServive;

@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {

    private BuscaEntregaService buscaEntregaService;
    private RegistroOcorrenciaServive registroOcorrenciaServive;
    private OcorrenciaMapper ocorrenciaMapper;

    public OcorrenciaController(RegistroOcorrenciaServive registroOcorrenciaServive,
            OcorrenciaMapper ocorrenciaMapper,
            BuscaEntregaService buscaEntregaService) {
        this.registroOcorrenciaServive = registroOcorrenciaServive;
        this.ocorrenciaMapper = ocorrenciaMapper;
        this.buscaEntregaService = buscaEntregaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OcorrenciaResponse registrar(@PathVariable Long entregaId,
            @Valid @RequestBody OcorrenciaResquest ocorrenciaResquest) {

        Ocorrencia ocorrenciaRegistrada = registroOcorrenciaServive
                .registrar(entregaId, ocorrenciaResquest.getDescricao());

        return ocorrenciaMapper.toOcorrencia(ocorrenciaRegistrada);
    }

    public List<OcorrenciaResponse> listar(@PathVariable Long entregaId) {
        Entrega entrega = buscaEntregaService.buscar(entregaId);

        return ocorrenciaMapper.toOcorrenciaCollection(entrega.getOcorrencias());
    }
}
