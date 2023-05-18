package com.example.crud.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "productos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Producto {

    @Id
    @Column(nullable = false,name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,name = "NOMBRE")
    private String nombre;

    @Column(nullable = false,name = "DESCRIPCION")
    private String descripcion;

    @Column(nullable = false,name = "PRECIO")
    private Double precio;

    @Column(name = "NOMBRE_ARCHIVO")
    private String nombreArchivo;

    @Column(name = "ARCHIVO", columnDefinition = "LONGBLOB")
    @JsonIgnore
    @Basic(fetch = FetchType.LAZY)
    private byte[] archivo;

}
