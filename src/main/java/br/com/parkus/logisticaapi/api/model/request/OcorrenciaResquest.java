package br.com.parkus.logisticaapi.api.model.request;

import javax.validation.constraints.NotBlank;

public class OcorrenciaResquest {

    @NotBlank
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
