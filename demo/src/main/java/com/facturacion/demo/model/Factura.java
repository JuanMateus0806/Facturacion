package com.facturacion.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name = "Facturas")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_factura")
    private int idFactura;

    private Date fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "documento")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JsonBackReference
    @Column(name = "cliente")
    private int cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "documento")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JsonBackReference
    @Column(name = "vendedor")
    private int vendedor;

    @Column(name = "tipo_pago")
    private char tipoPago;

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<DetalleFactura> detalleFacturas = new HashSet<>();
}
