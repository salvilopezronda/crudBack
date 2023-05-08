package com.example.crud.repository;

import com.example.crud.domain.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {


    @Query(value = "SELECT * " +
            " FROM productos a " +
            " WHERE a.nombre LIKE %:nombre% ",
            nativeQuery = true,
            countQuery = "select count(1) " +
                    " FROM productos a " +
                    " WHERE a.nombre LIKE %:nombre% ")
    Page<Producto> getProductos(@Param("nombre") String nombre, Pageable pageable);

}






