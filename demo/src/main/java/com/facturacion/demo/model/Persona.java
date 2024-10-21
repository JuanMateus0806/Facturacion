package com.facturacion.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor

@Table(name = "Personas")
public class Persona {

    private int documento;

    @Column(name = "tipo_documento")
    private String tipoDocumento;

    private String nombres;
    private String apellidos;
    private String correo;
    private char genero;
    private String direccion;
    private int telefono;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<Usuario> usuarios = new HashSet<>();

    @OneToMany(mappedBy = "vendedor", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<Factura> facturasVendedor = new HashSet<>();

    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<Factura> facturasCliente = new HashSet<>();

}
