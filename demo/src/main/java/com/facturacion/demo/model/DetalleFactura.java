package com.facturacion.demo.model;

import com.facturacion.demo.model.embedded_id.DetallesFacturaKey;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DetalleFactura {

    @EmbeddedId
    private DetallesFacturaKey id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_factura")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @MapsId("idFactura")
    private Factura factura;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_producto")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @MapsId("idProducto")
    private Producto producto;

    private int cantidad;
    private int iva;

}
