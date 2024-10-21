package com.facturacion.demo.model.embedded_id;

import jakarta.persistence.Column;

import java.io.Serializable;
import java.util.Objects;

public class DetallesFacturaKey implements Serializable {

    @Column(name = "id_producto")
    private Integer idProducto;

    @Column(name = "id_factura")
    private Integer idFactura;

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DetallesFacturaKey that = (DetallesFacturaKey) o;

        if (!Objects.equals(idProducto, that.idProducto)) return false;
        return Objects.equals(idFactura, that.idFactura);
    }

    @Override
    public int hashCode() {
        int result = idProducto != null ? idProducto.hashCode(): 0;
        result = 31 * result + (idFactura != null ? idFactura.hashCode(): 0);
        return result;
    }
}
