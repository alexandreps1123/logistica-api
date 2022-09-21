package br.com.parkus.logisticaapi.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.parkus.logisticaapi.domain.exception.NegocioException;
import br.com.parkus.logisticaapi.domain.model.Cliente;
import br.com.parkus.logisticaapi.domain.repository.ClienteRepository;

@Service
public class CatalogoClienteService {
    
    private ClienteRepository clienteRepository;

    public CatalogoClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente buscar(Long clienteId) {
        return clienteRepository.findById(clienteId)
        .orElseThrow(() -> new NegocioException("Cliente não encontrado."));

    }

    @Transactional
    public Cliente salvar(Cliente cliente) {
        boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
                .stream()
                .anyMatch(clienteExistente -> !clienteExistente.equals(cliente));

            if(emailEmUso) {
                throw new NegocioException("Já existe um cliente cadastrado com este email.");
            }
        
        return clienteRepository.save(cliente);
    }

    @Transactional
    public void excluir(Long clienteId) {
        clienteRepository.deleteById(clienteId);
    }
}
