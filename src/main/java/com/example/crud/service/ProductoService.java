package com.example.crud.service;

import com.example.crud.dto.FicheroDTO;
import com.example.crud.dto.FiltroProductoDTO;
import com.example.crud.dto.ProductoDTO;
import com.example.crud.exceptions.EntityNotFoundException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductoService {

    List<ProductoDTO> obtenerTodos();

    Page<ProductoDTO> obtenerTodosPaginado(FiltroProductoDTO requestSearchDTO);

    ProductoDTO obtenerPorId(Long id) throws EntityNotFoundException;

    void crear(ProductoDTO productoDto);

    void modificar(ProductoDTO productoDto) throws EntityNotFoundException;

    void eliminar(Long id);

    FicheroDTO descargarFichero(Long idProducto) throws EntityNotFoundException;
}
