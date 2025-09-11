package com.leonelcujcuj.tienda_repuestos.repository;

import com.leonelcujcuj.tienda_repuestos.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Optional<Cliente> findByCorreo(String correo);
    Optional<Cliente> findByTelefono(String telefono);
    List<Cliente> findAllByCorreo(String correo);

}
