package com.example.crud.repository;

import com.example.crud.domain.Producto;
import com.example.crud.shared.repository.BaseJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends BaseJpaRepository<Producto, Long> {


    @Query(value = "SELECT * " +
            " FROM productos a " +
            " WHERE a.nombre LIKE %:nombre% ",
            nativeQuery = true,
            countQuery = "select count(1) " +
                    " FROM productos a " +
                    " WHERE a.nombre LIKE %:nombre% ")
    Page<Producto> getProductos(@Param("nombre") String nombre, Pageable pageable);

    Page<Producto> findByNombreLike(String nombre, Pageable pageable);

    public static Specification<Producto> findByNombreEspecification(String nombre) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("nombre"), "%" + nombre + "%");
    }

}






