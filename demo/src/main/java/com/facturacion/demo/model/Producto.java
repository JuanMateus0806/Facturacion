package com.facturacion.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private int idProducto;

    private String nombre;
    private String unidadMedida;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<DetalleFactura> detalleFacturas = new HashSet<>();

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<ProductoLote> productoLotes = new HashSet<>();

}
