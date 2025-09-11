package com.leonelcujcuj.tienda_repuestos.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "factura")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_factura")
    private Integer idFactura;

    @Column(name = "fecha")
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false,
            foreignKey = @ForeignKey(name = "fk_id_cliente"))
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_empleado", nullable = false,
            foreignKey = @ForeignKey(name = "fk_id_empleado"))
    private Empleado empleado;

    @Column(name = "total", precision = 10)
    private Float total;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
