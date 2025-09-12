package com.leonelcujcuj.tienda_repuestos.service;

import com.leonelcujcuj.tienda_repuestos.model.Cliente;
import com.leonelcujcuj.tienda_repuestos.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente getClienteById(Integer id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public Cliente saveCliente(Cliente cliente) {
        if (clienteRepository.findByCorreo(cliente.getCorreo()).isPresent()) {
            throw new IllegalArgumentException("El correo ya está registrado");
        }
        if (!clienteRepository.findAllByTelefono(cliente.getTelefono()).isEmpty()) {
            throw new IllegalArgumentException("El teléfono ya está registrado");
        }
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente updateCliente(Integer id, Cliente cliente) {
        Cliente existente = clienteRepository.findById(id).orElse(null);
        if (existente != null) {
            existente.setNombre(cliente.getNombre());
            existente.setTelefono(cliente.getTelefono());
            existente.setCorreo(cliente.getCorreo());
            existente.setDireccion(cliente.getDireccion());
            return clienteRepository.save(existente);
        }
        return null;
    }

    @Override
    public void deleteCliente(Integer id) {
        try {
            clienteRepository.deleteById(id);
        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            throw new IllegalArgumentException("No se puede eliminar: el cliente está asociado a una factura");
        }
    }
}