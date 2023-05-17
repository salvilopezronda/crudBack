package com.example.crud.service;

import com.example.crud.domain.Producto;
import com.example.crud.dto.FiltroProductoDTO;
import com.example.crud.dto.ProductoDTO;
import com.example.crud.dto.ProductoMapperImpl;
import com.example.crud.exceptions.EntityNotFoundException;
import com.example.crud.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ProductoMapperImpl productoMapper;


    @Override
    public List<ProductoDTO> obtenerTodos() {
        return productoRepository.buscar().stream().map(productoMapper::productoToProductoDTO).collect(Collectors.toList());
    }

    @Override
    public Page<ProductoDTO> obtenerTodosPaginado(FiltroProductoDTO filtro) {
        Pageable pageable = PageRequest.of(filtro.getPage(), filtro.getSize(), Sort.by(filtro.getSort()).ascending());
        //TODO Consulta name query

        // Page<Producto> page = productoRepository.getProductos(filtro.getNombre(), pageable);
        //TODO Consulta specification

        //Specification<Producto> spec = ProductoRepository.findByNombreEspecification(filtro.getNombre());
        // Page<Producto> page =productoRepository.findAll(spec,pageable);

        //TODO Consulta jpaRepository
        Page<Producto> page = productoRepository.findByNombreLike("%" + filtro.getNombre() + "%", pageable);

        return page.map(productoMapper::productoToProductoDTO);
    }


    @Override
    public ProductoDTO obtenerPorId(Long id) throws EntityNotFoundException {
        return productoMapper.productoToProductoDTO(productoRepository.buscarPorId(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontró el producto con id: " + id)));
    }

    @Override
    public void crear(ProductoDTO productoDto) {
        productoRepository.crear(productoMapper.productoDTOToProductoCreate(productoDto));
    }

    @Override
    public void modificar(ProductoDTO productoDto) throws EntityNotFoundException {
        Producto producto = productoRepository.findById(productoDto.getId()).orElseThrow(() -> new EntityNotFoundException("No se encontró el producto con id: " + productoDto.getId()));
        productoRepository.actualizar(productoMapper.productoDTOToProductoModify(productoDto, producto));
    }

    @Override
    public void eliminar(Long id) {
        productoRepository.eliminar(id);
    }
}
