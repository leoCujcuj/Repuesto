package com.leonelcujcuj.tienda_repuestos.repository;

import com.leonelcujcuj.tienda_repuestos.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Optional<Cliente> findByCorreo(String correo);
    List<Cliente> findAllByTelefono(String telefono);
}
