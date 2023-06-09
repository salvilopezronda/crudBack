package com.example.crud.dto;

import lombok.Data;

@Data
public class ProductoDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private String nombreArchivo;
    private String archivo;
    private String fechaAlta;
}
