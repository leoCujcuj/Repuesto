package com.leonelcujcuj.tienda_repuestos.service;

import com.leonelcujcuj.tienda_repuestos.model.Proveedor;
import com.leonelcujcuj.tienda_repuestos.repository.ProveedorRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorServiceImpl implements ProveedorService{

    private final ProveedorRepository proveedorRepository;

    public ProveedorServiceImpl(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    @Override
    public void deleteProveedor(Integer id) {
        try{
            proveedorRepository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new IllegalArgumentException("No se puede eliminar: el proveedor está asociado a un repuesto");
        }
    }

    @Override
    public List<Proveedor> getAllProveedores() {
        return proveedorRepository.findAll();
    }

    @Override
    public Proveedor getClienteById(Integer id) {
        return proveedorRepository.findById(id).orElse(null);
    }

    @Override
    public Proveedor saveProveedor(Proveedor proveedor) {
        if (proveedorRepository.findByNombre(proveedor.getNombre()).isPresent()) {
            throw new IllegalArgumentException("El nombre ya está registrado");
        }
        if (proveedorRepository.findByCorreo(proveedor.getCorreo()).isPresent()) {
            throw new IllegalArgumentException("El correo ya está registrado");
        }
        return proveedorRepository.save(proveedor);
    }

    @Override
    public Proveedor updateProveedor(Integer id, Proveedor proveedor) {
        Proveedor existente = proveedorRepository.findById(id).orElse(null);
        if (existente != null) {
            existente.setNombre(proveedor.getNombre());
            existente.setTelefono(proveedor.getTelefono());
            existente.setCorreo(proveedor.getCorreo());
            existente.setDireccion(proveedor.getDireccion());
            return proveedorRepository.save(existente);
        }
        return proveedorRepository.save(proveedor);
    }
}
