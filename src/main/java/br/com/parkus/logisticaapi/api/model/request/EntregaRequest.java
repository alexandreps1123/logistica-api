package br.com.parkus.logisticaapi.api.model.request;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class EntregaRequest {

    @Valid
    @NotNull
    private ClienteIdRequest clienteId;

    @Valid
    @NotNull
    private DestinatarioRequest destinatario;

    @NotNull
    private BigDecimal taxa;

    public ClienteIdRequest getClienteId() {
        return clienteId;
    }

    public void setClienteId(ClienteIdRequest clienteId) {
        this.clienteId = clienteId;
    }

    public DestinatarioRequest getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(DestinatarioRequest destinatario) {
        this.destinatario = destinatario;
    }

    public BigDecimal getTaxa() {
        return taxa;
    }

    public void setTaxa(BigDecimal taxa) {
        this.taxa = taxa;
    }

}
