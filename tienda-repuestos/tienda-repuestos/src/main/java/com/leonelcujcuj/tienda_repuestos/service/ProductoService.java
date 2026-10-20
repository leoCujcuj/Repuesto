package com.leonelcujcuj.tienda_repuestos.service;

import com.leonelcujcuj.tienda_repuestos.model.Producto;

import java.util.List;

public interface ProductoService {
    List<Producto> getAllProductos();
    Producto getProductoByid(Integer id);
    Producto saveProducto(Producto producto);
    Producto updateProducto(Integer id, Producto producto);
    void deleteProducto(Integer id);
}
