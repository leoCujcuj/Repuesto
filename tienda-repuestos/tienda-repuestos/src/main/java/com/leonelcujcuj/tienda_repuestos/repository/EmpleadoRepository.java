package com.leonelcujcuj.tienda_repuestos.repository;

import com.leonelcujcuj.tienda_repuestos.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {

}