package br.com.parkus.logisticaapi.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.parkus.logisticaapi.domain.model.Cliente;
import br.com.parkus.logisticaapi.domain.repository.ClienteRepository;
import br.com.parkus.logisticaapi.domain.service.CatalogoClienteService;

@RestController
@RequestMapping("clientes")
public class ClienteController {
    
    private ClienteRepository clienteRepository;
    private CatalogoClienteService catalogoClienteService;

    public ClienteController(ClienteRepository clienteRepository, CatalogoClienteService catalogoClienteService) {
        this.clienteRepository = clienteRepository;
        this.catalogoClienteService = catalogoClienteService;
    }

    @GetMapping
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId) {
        // Optional<Cliente> cliente = clienteRepository.findById(clienteId);

        // if(cliente.isPresent()) {
        //     return ResponseEntity.ok(cliente.get());
        // }

        // return ResponseEntity.notFound().build();

        return clienteRepository.findById(clienteId)
                // .map(cliente -> ResponseEntity.ok(cliente))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionar(@Valid @RequestBody Cliente cliente) {
        return catalogoClienteService.salvar(cliente);
    }

    @PutMapping("/{clienteId}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long clienteId, 
            @Valid  @RequestBody Cliente cliente) {
        
        if(!clienteRepository.existsById(clienteId)) {
            return ResponseEntity.notFound().build();
        }

        cliente.setId(clienteId);
        cliente = clienteRepository.save(cliente);

        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Void> remover(@PathVariable Long clienteId) {
        if(!clienteRepository.existsById(clienteId)) {
            return ResponseEntity.notFound().build();
        }

        catalogoClienteService.excluir(clienteId);

        return ResponseEntity.noContent().build();
    }
}
