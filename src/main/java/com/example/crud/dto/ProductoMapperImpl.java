package com.example.crud.dto;

import com.example.crud.domain.Producto;
import org.springframework.stereotype.Service;

@Service
public class ProductoMapperImpl{


    public ProductoDTO productoToProductoDTO(Producto producto) {
        if (producto == null) {
            return null;
        }

        ProductoDTO productoDTO = new ProductoDTO();

        productoDTO.setId(producto.getId());
        productoDTO.setNombre(producto.getNombre());
        productoDTO.setDescripcion(producto.getDescripcion());
        productoDTO.setPrecio(producto.getPrecio());

        return productoDTO;
    }

    public Producto productoDTOToProducto(ProductoDTO ProductoDto) {
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
    public Producto productoDTOToProductoModify(ProductoDTO ProductoDto, Producto producto) {
        if (ProductoDto == null) {
            return null;
        }
        producto.setId(ProductoDto.getId());
        producto.setNombre(ProductoDto.getNombre());
        producto.setDescripcion(ProductoDto.getDescripcion());
        producto.setPrecio(ProductoDto.getPrecio());

        return producto;
    }
    public Producto productoDTOToProductoCreate(ProductoDTO ProductoDto) {
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
