package com.leonelcujcuj.tienda_repuestos.controller;


import com.leonelcujcuj.tienda_repuestos.model.Proveedor;
import com.leonelcujcuj.tienda_repuestos.service.ProveedorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/proveedor")
public class ProveedorController {

    private final ProveedorService proveedorService;

    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    @GetMapping
    public List<Proveedor> getAllProveedores(){
        return proveedorService.getAllProveedores();
    }

    @PostMapping
    public Proveedor createProveedor(@RequestBody Proveedor proveedor){
        return proveedorService.saveProveedor(proveedor);
    }

    @GetMapping("/{id}")
    public Proveedor getProveedorById(@PathVariable Integer id){
        return proveedorService.getClienteById(id);
    }

    @PutMapping( "/{id}")
    public Proveedor updateProveedor(@PathVariable Integer id, @RequestBody Proveedor proveedor){
        return proveedorService.updateProveedor(id, proveedor);
    }

    @DeleteMapping("{id}")
    public void deleteProveedor(@PathVariable Integer id){
        proveedorService.deleteProveedor(id);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleDuplicate(IllegalArgumentException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
