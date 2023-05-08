package com.example.crud.controller;

import com.example.crud.dto.ProductoDTO;
import com.example.crud.dto.RequestSearchDTO;
import com.example.crud.exceptions.EntityNotFoundException;
import com.example.crud.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("")
    public ResponseEntity<List<ProductoDTO>> obtenerTodos() {
        return ResponseEntity.ok(productoService.obtenerTodos());
    }

    @PostMapping("/paginado")
    public ResponseEntity<Page<ProductoDTO>> obtenerTodosPaginado(@RequestBody RequestSearchDTO requestSearchDTO) {
        return ResponseEntity.ok(productoService.obtenerTodosPaginado(requestSearchDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> obtenerPorId(@PathVariable Long id) throws EntityNotFoundException {
        return ResponseEntity.ok(productoService.obtenerPorId(id));
    }

    @PostMapping("")
    public ResponseEntity<Void> crear(@RequestBody ProductoDTO productoDto) {
        productoService.crear(productoDto);
        return ResponseEntity.created(URI.create("/productos/" + productoDto.getId())).build();
    }

    @PutMapping("")
    public ResponseEntity<Void> modificar(@RequestBody ProductoDTO productoDto) throws EntityNotFoundException {
        productoService.modificar(productoDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        productoService.eliminar(id);
        return ResponseEntity.ok().build();
    }

}


