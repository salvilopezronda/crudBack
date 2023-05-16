package com.example.crud.controller;

import com.example.crud.dto.FiltroProductoDTO;
import com.example.crud.dto.ProductoDTO;
import com.example.crud.exceptions.AccesDataException;
import com.example.crud.exceptions.EntityNotFoundException;
import com.example.crud.service.ProductoService;
import com.example.crud.shared.CrudConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.expression.AccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController extends BaseController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("")
    public ResponseEntity<List<ProductoDTO>> obtenerTodos() throws AccesDataException {
        this.comprobarAutorizacion(CrudConstants.ROL_ADMINISTRADOR);
        return ResponseEntity.ok(this.productoService.obtenerTodos());
    }

    @PostMapping("/paginado")
    public ResponseEntity<Page<ProductoDTO>> obtenerTodosPaginado(@RequestBody FiltroProductoDTO filtro) {
        return ResponseEntity.ok(this.productoService.obtenerTodosPaginado(filtro));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> obtenerPorId(@PathVariable Long id) throws EntityNotFoundException {
        return ResponseEntity.ok(this.productoService.obtenerPorId(id));
    }

    @PostMapping("")
    public ResponseEntity<Void> crear(@RequestBody ProductoDTO productoDto) {
        this.productoService.crear(productoDto);
        return ResponseEntity.created(URI.create("/productos/" + productoDto.getId())).build();
    }

    @PutMapping("")
    public ResponseEntity<Void> modificar(@RequestBody ProductoDTO productoDto) throws EntityNotFoundException {
        this.productoService.modificar(productoDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        this.productoService.eliminar(id);
        return ResponseEntity.ok().build();
    }

}


