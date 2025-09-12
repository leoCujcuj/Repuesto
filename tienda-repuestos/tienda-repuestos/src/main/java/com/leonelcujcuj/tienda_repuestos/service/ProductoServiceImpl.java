package com.leonelcujcuj.tienda_repuestos.service;

import com.leonelcujcuj.tienda_repuestos.model.Producto;
import com.leonelcujcuj.tienda_repuestos.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto getProductoByid(Integer id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public Producto saveProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto updateProducto(Integer id, Producto producto) {
        Producto existente = productoRepository.findById(id).orElse(null);
        if(existente != null){
            existente.setNombre(producto.getNombre());
            existente.setPrecio(producto.getPrecio());
            existente.setStock(producto.getStock());
            existente.setProveedor(producto.getProveedor());
        }
        return productoRepository.save(producto);
    }

    @Override
    public void deleteProducto(Integer id) {
        productoRepository.deleteById(id);
    }
}
