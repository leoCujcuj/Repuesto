package com.leonelcujcuj.tienda_repuestos.service;

import com.leonelcujcuj.tienda_repuestos.model.Factura;
import com.leonelcujcuj.tienda_repuestos.repository.FacturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaServiceImpl implements FacturaService{
    private final FacturaRepository facturaRepository;

    public FacturaServiceImpl(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }


    @Override
    public List<Factura> getAllFacturas() {
        return facturaRepository.findAll();
    }

    @Override
    public Factura getFacturaById(Integer id) {
        return facturaRepository.findById(id).orElse(null);
    }

    @Override
    public Factura saveFactura(Factura factura) {
        return facturaRepository.save(factura);
    }

    @Override
    public Factura updateFactura(Integer id, Factura factura) {
        Factura existente = facturaRepository.findById(id).orElse(null);
        if (existente != null) {
            existente.setTotal(factura.getTotal());
            existente.setFecha(factura.getFecha());
            existente.setCliente(factura.getCliente());
            existente.setEmpleado(factura.getEmpleado());
            return facturaRepository.save(existente);
        }
        return null;
    }

    @Override
    public void deleteFactura(Integer id) {
        facturaRepository.deleteById(id);
    }
}
