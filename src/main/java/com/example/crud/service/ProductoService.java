package com.example.crud.service;

import com.example.crud.dto.ProductoDto;
import com.example.crud.exceptions.EntityNotFoundException;

import java.util.List;

public interface ProductoService {

    List<ProductoDto> obtenerTodos();

    ProductoDto obtenerPorId(Long id) throws EntityNotFoundException;

    void crear(ProductoDto productoDto);

    void modificar(ProductoDto productoDto) throws EntityNotFoundException;

    void eliminar(Long id);
}
