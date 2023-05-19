package com.example.crud.dto;

import com.example.crud.domain.Producto;
import com.example.crud.shared.Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Service
public class ProductoMapperImpl {

    private final String LOCAL_DATE_PATTERN= "dd/MM/yyyy";

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
        if (producto.getFechaAlta() != null) {
            productoDTO.setFechaAlta(producto.getFechaAlta().format(DateTimeFormatter.ofPattern(LOCAL_DATE_PATTERN)));
        }

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
        if(StringUtils.isNotBlank(productoDto.getFechaAlta())){
            producto.setFechaAlta(LocalDate.parse(productoDto.getFechaAlta(),DateTimeFormatter.ofPattern(LOCAL_DATE_PATTERN)));
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

        if (((StringUtils.isNotBlank(productoDto.getNombreArchivo()))&&productoDto.getArchivo()!=null)
                ||(StringUtils.isBlank(productoDto.getNombreArchivo())&&productoDto.getArchivo()==null)){
            producto.setNombreArchivo(productoDto.getNombreArchivo());
            producto.setArchivo(Util.convertiraByte(productoDto.getArchivo()));
            if(StringUtils.isNotBlank(productoDto.getFechaAlta())){
                producto.setFechaAlta(LocalDate.parse(productoDto.getFechaAlta(),DateTimeFormatter.ofPattern(LOCAL_DATE_PATTERN)));
            }
        }
        return producto;
    }
}
