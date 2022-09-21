package br.com.parkus.logisticaapi.api.mapper;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.parkus.logisticaapi.api.model.response.OcorrenciaResponse;
import br.com.parkus.logisticaapi.domain.model.Ocorrencia;

@Component
public class OcorrenciaMapper {

    private ModelMapper modelMapper;

    public OcorrenciaMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public OcorrenciaResponse toOcorrencia(Ocorrencia ocorrencia) {
        return modelMapper.map(ocorrencia, OcorrenciaResponse.class);
    }

    public List<OcorrenciaResponse> toOcorrenciaCollection(List<Ocorrencia> ocorrencias) {
        return ocorrencias.stream()
                .map(this::toOcorrencia)
                .collect(Collectors.toList());
    }

}
