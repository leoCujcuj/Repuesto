package com.leonelcujcuj.tienda_repuestos.service;

import com.leonelcujcuj.tienda_repuestos.model.Proveedor;

import java.util.List;

public interface ProveedorService {
    List<Proveedor> getAllProveedores();
    Proveedor getClienteById(Integer id);
    Proveedor saveProveedor(Proveedor proveedor);
    Proveedor updateProveedor(Integer id, Proveedor proveedor);
    void deleteProveedor(Integer id);
}
