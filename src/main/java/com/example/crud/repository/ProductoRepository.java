package com.example.crud.repository;

import com.example.crud.domain.Producto;
import com.example.crud.shared.repository.BaseJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends BaseJpaRepository<Producto, Long> {


    Page<Producto> findByNombreLike(String nombre, Pageable pageable);

}






