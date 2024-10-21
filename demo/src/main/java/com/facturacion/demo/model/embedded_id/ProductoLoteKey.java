package com.facturacion.demo.model.embedded_id;

import jakarta.persistence.Column;

import java.io.Serializable;
import java.util.Objects;

public class ProductoLoteKey implements Serializable {

    @Column(name = "id_producto")
    private Integer idProducto;

    @Column(name = "id_lote")
    private Integer idLote;

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductoLoteKey that = (ProductoLoteKey) o;

        if (!Objects.equals(idProducto, that.idProducto)) return false;
        return Objects.equals(idLote, that.idLote);
    }

    @Override
    public int hashCode() {
        int result = idProducto != null ? idProducto.hashCode(): 0;
        result = 31 * result + (idLote != null ? idLote.hashCode(): 0);
        return result;
    }

}
