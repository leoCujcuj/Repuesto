package com.leonelcujcuj.tienda_repuestos.repository;

import com.leonelcujcuj.tienda_repuestos.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}