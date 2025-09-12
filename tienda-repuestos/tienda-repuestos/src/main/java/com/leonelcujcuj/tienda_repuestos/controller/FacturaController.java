package com.leonelcujcuj.tienda_repuestos.controller;


import com.leonelcujcuj.tienda_repuestos.model.Factura;
import com.leonelcujcuj.tienda_repuestos.service.FacturaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/factura")
public class FacturaController {

    private final FacturaService facturaService;


    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    @GetMapping
    public Iterable<Factura> getAllFacturas(){
        return facturaService.getAllFacturas();
    }

    @GetMapping("/{id}")
    public Factura getFacturaById(@PathVariable Integer id){
        return facturaService.getFacturaById(id);
    }

    @PostMapping
    public Factura createFactura(@RequestBody Factura factura){
        return facturaService.saveFactura(factura);
    }

    @PutMapping("/{id}")
    public Factura updateFactura(@PathVariable Integer id, @RequestBody Factura factura){
        return facturaService.updateFactura(id, factura);
    }

    @DeleteMapping("/{id}")
    public void deleteFactura(@PathVariable Integer id){
        facturaService.deleteFactura(id);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleDuplicate(IllegalArgumentException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
