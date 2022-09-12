package br.com.parkus.logisticaapi.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.parkus.logisticaapi.domain.model.Cliente;

@RestController
public class ClienteController {
    
    @GetMapping("clientes")
    public List<Cliente> listar() {

        var cliente1 = new Cliente();
        cliente1.setId(1L);
        cliente1.setNome("Abreu");
        cliente1.setTelefone("+55 61 99999-9999");
        cliente1.setEmail("abreunaoleu@comeu.com");

        var cliente2 = new Cliente();
        cliente2.setId(1L);
        cliente2.setNome("Escandinávia");
        cliente2.setTelefone("+123 61 98599-9999");
        cliente2.setEmail("ascandileia@comeu.com");
        
        return Arrays.asList(cliente1, cliente2);
    }
}
