package com.example.crud.dto;

import lombok.Data;

@Data
public class FiltroProductoDTO extends RequestSearchDTO{
    private String nombre;
    private String descripcion;

}
