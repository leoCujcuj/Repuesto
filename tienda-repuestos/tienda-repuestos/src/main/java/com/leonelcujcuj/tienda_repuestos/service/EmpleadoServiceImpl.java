package com.leonelcujcuj.tienda_repuestos.service;

import com.leonelcujcuj.tienda_repuestos.model.Empleado;
import com.leonelcujcuj.tienda_repuestos.repository.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public List<Empleado> getAllEmpleados() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado getEmpleadoById(Integer id) {
        return empleadoRepository.findById(id).orElse(null);
    }

    @Override
    public Empleado saveEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public Empleado updateEmpleado(Integer id, Empleado empleado) {
        Empleado existente = empleadoRepository.findById(id).orElse(null);
        if (existente != null){
            existente.setNombre(empleado.getNombre());
            existente.setPuesto(empleado.getPuesto());
            existente.setSalario(empleado.getSalario());
            return empleadoRepository.save(existente);
        }
        return null;
    }

    @Override
    public void deleteEmpleado(Integer id) {
        try{
            empleadoRepository.deleteById(id);
        }catch (org.springframework.dao.DataIntegrityViolationException e){
            throw new IllegalArgumentException("No se puede eliminar: el empleado está asociado a una factura");
        }
    }
}
