package com.facturacion.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
public class Lote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lote")
    private int idLote;

    private Date fecha;

    @OneToMany(mappedBy = "lote", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<ProductoLote> productoLotes = new HashSet<>();

}
