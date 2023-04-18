package com.example.crud.dto;

import com.example.crud.domain.Producto;
import org.springframework.stereotype.Service;

@Service
public class ProductoMapperImpl{


    public ProductoDto productoToProductoDTO(Producto producto) {
        if (producto == null) {
            return null;
        }

        ProductoDto productoDTO = new ProductoDto();

        productoDTO.setId(producto.getId());
        productoDTO.setNombre(producto.getNombre());
        productoDTO.setDescripcion(producto.getDescripcion());
        productoDTO.setPrecio(producto.getPrecio());

        return productoDTO;
    }

    public Producto productoDTOToProducto(ProductoDto ProductoDto) {
        if (ProductoDto == null) {
            return null;
        }

        Producto producto = new Producto();

        producto.setId(ProductoDto.getId());
        producto.setNombre(ProductoDto.getNombre());
        producto.setDescripcion(ProductoDto.getDescripcion());
        producto.setPrecio(ProductoDto.getPrecio());

        return producto;
    }
    public Producto productoDTOToProductoModify(ProductoDto ProductoDto,Producto producto) {
        if (ProductoDto == null) {
            return null;
        }
        producto.setId(ProductoDto.getId());
        producto.setNombre(ProductoDto.getNombre());
        producto.setDescripcion(ProductoDto.getDescripcion());
        producto.setPrecio(ProductoDto.getPrecio());

        return producto;
    }
    public Producto productoDTOToProductoCreate(ProductoDto ProductoDto) {
        if (ProductoDto == null) {
            return null;
        }

        Producto producto = new Producto();
        producto.setNombre(ProductoDto.getNombre());
        producto.setDescripcion(ProductoDto.getDescripcion());
        producto.setPrecio(ProductoDto.getPrecio());

        return producto;
    }
}
