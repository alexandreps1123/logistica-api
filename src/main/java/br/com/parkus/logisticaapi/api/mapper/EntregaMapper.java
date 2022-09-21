package br.com.parkus.logisticaapi.api.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.parkus.logisticaapi.api.model.request.EntregaRequest;
import br.com.parkus.logisticaapi.api.model.response.EntregaResponse;
import br.com.parkus.logisticaapi.domain.model.Entrega;

@Component
public class EntregaMapper {
    
    private ModelMapper modelMapper;

    public EntregaResponse toEntregaResponse(Entrega entrega) {
        return modelMapper.map(entrega, EntregaResponse.class);
    }

    public List<EntregaResponse> toCollectionEntregaResponse(List<Entrega> entregas) {
        return entregas.stream()
                .map(this::toEntregaResponse)
                .collect(Collectors.toList());
    }

    public Entrega fromEntregaRequest(EntregaRequest entregaRequest) {
        return modelMapper.map(entregaRequest, Entrega.class);
    }
}
