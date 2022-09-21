package br.com.parkus.logisticaapi.api.model.response;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import br.com.parkus.logisticaapi.domain.model.StatusEntrega;

public class EntregaResponse {

    private Long id;
    private ClienteIdNomeResponse idNome;
    private DestinatarioResponse destinatario;
    private BigDecimal taxa;
    private StatusEntrega status;
    private OffsetDateTime dataPedido;
    private OffsetDateTime dataFinalizacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClienteIdNomeResponse getNomeCliente() {
        return idNome;
    }

    public void setIdNome(ClienteIdNomeResponse idNome) {
        this.idNome = idNome;
    }

    public DestinatarioResponse getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(DestinatarioResponse destinatario) {
        this.destinatario = destinatario;
    }

    public BigDecimal getTaxa() {
        return taxa;
    }

    public void setTaxa(BigDecimal taxa) {
        this.taxa = taxa;
    }

    public StatusEntrega getStatus() {
        return status;
    }

    public void setStatus(StatusEntrega status) {
        this.status = status;
    }

    public OffsetDateTime getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(OffsetDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }

    public OffsetDateTime getDataFinalizacao() {
        return dataFinalizacao;
    }

    public void setDataFinalizacao(OffsetDateTime dataFinalizacao) {
        this.dataFinalizacao = dataFinalizacao;
    }
}
