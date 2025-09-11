package com.leonelcujcuj.tienda_repuestos.repository;

import com.leonelcujcuj.tienda_repuestos.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {
    Optional<Proveedor> findByNombre(String nombre);
}
