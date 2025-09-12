package com.leonelcujcuj.tienda_repuestos.service;

import com.leonelcujcuj.tienda_repuestos.model.Factura;

import java.util.List;

public interface FacturaService {
    List<Factura> getAllFacturas();
    Factura getFacturaById(Integer id);
    Factura saveFactura(Factura factura);
    Factura updateFactura(Integer id, Factura factura);
    void deleteFactura(Integer id);
}
