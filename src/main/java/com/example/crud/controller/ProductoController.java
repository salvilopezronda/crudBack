package com.example.crud.controller;

import com.example.crud.dto.ProductoDto;
import com.example.crud.exceptions.EntityNotFoundException;
import com.example.crud.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<List<ProductoDto>> obtenerTodos() {
        return ResponseEntity.ok(productoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDto> obtenerPorId(@PathVariable Long id) throws EntityNotFoundException {
        return ResponseEntity.ok(productoService.obtenerPorId(id));
    }

    @PostMapping("")
    public ResponseEntity<Void> crear(@RequestBody ProductoDto ProductoDto) {
        productoService.crear(ProductoDto);
        return ResponseEntity.created(URI.create("/productos/" + ProductoDto.getId())).build();
    }

    @PutMapping("")
    public ResponseEntity<Void> modificar(@RequestBody ProductoDto productoDto) throws EntityNotFoundException {
        productoService.modificar(productoDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        productoService.eliminar(id);
        return ResponseEntity.ok().build();
    }

}


