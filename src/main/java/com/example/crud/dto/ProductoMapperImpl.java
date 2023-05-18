package com.example.crud.dto;

import com.example.crud.domain.Producto;
import com.example.crud.shared.Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;


@Service
public class ProductoMapperImpl {


    public ProductoDTO productoToProductoDTO(Producto producto) {
        if (producto == null) {
            return null;
        }

        ProductoDTO productoDTO = new ProductoDTO();

        productoDTO.setId(producto.getId());
        productoDTO.setNombre(producto.getNombre());
        productoDTO.setDescripcion(producto.getDescripcion());
        productoDTO.setPrecio(producto.getPrecio());
        productoDTO.setNombreArchivo(producto.getNombreArchivo());
        return productoDTO;
    }

    public Producto productoDTOToProductoModify(ProductoDTO productoDto, Producto producto) {
        if (productoDto == null) {
            return null;
        }
        producto.setId(productoDto.getId());
        producto.setNombre(productoDto.getNombre());
        producto.setDescripcion(productoDto.getDescripcion());
        producto.setPrecio(productoDto.getPrecio());
        if (((StringUtils.isNotBlank(productoDto.getNombreArchivo()))&&productoDto.getArchivo()!=null)
        ||(StringUtils.isBlank(productoDto.getNombreArchivo())&&productoDto.getArchivo()==null)){
            producto.setNombreArchivo(productoDto.getNombreArchivo());
            producto.setArchivo(Util.convertiraByte(productoDto.getArchivo()));
        }
        return producto;
    }

    public Producto productoDTOToProductoCreate(ProductoDTO productoDto) {
        if (productoDto == null) {
            return null;
        }

        Producto producto = new Producto();
        producto.setNombre(productoDto.getNombre());
        producto.setDescripcion(productoDto.getDescripcion());
        producto.setPrecio(productoDto.getPrecio());
        producto.setNombreArchivo(producto.getNombreArchivo());
        return producto;
    }
}
