package com.facturacion.demo.model;

import com.facturacion.demo.model.embedded_id.ProductoLoteKey;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductoLote {

    @EmbeddedId
    private ProductoLoteKey id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_producto")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @MapsId("idProducto")
    private Producto producto;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_lote")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @MapsId("idLote")
    private Lote lote;

    private int cantidad;

    @Column(name = "valor_unitario")
    private int valorUnitario;

    @Column(name = "fecha_vencimiento")
    private Date fechaVencimiento;

}
