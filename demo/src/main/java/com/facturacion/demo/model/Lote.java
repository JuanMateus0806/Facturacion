package com.facturacion.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
public class Lote {

    private int idLote;
    private Date fecha;

    @OneToMany(mappedBy = "lote", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<ProductoLote> productoLotes = new HashSet<>();

}
