package com.example.crud.repository;

import com.example.crud.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

  /*  @Query(value = "SELECT * "+
            " FROM EST_AUDITORIAS a ",
            nativeQuery = true,
            countQuery = "select count(1) " +
            " FROM EST_AUDITORIAS a ")
    Page<Producto> getProductos(Pageable pageable);

    @Query(value = "SELECT a "+
            " FROM Producto a ")
    Page<Producto> getProductos(Pageable pageable);*/
}
