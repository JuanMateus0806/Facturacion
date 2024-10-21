package com.facturacion.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Usuario {

    @Id
    private String login;

    private String contraseña;

    private String tipoUsuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "documento")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JsonBackReference
    private Persona persona;

}
