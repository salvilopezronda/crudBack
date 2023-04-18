package com.example.crud.dto;

import lombok.Data;

@Data

public class ProductoDto {

    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;

}
