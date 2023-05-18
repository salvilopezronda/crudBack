package com.example.crud.shared.repository;

import com.example.crud.domain.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface BaseJpaRepository<T, ID> extends JpaRepository<T, ID> , JpaSpecificationExecutor<Producto> {

    default long contar() {
        return this.count();
    }

    default List<T> buscar() {
        return this.findAll();
    }
    default Optional<T> buscarPorId(ID id) {
        return this.findById(id);
    }
    default Page<T> buscar(Pageable pageable) {
        return this.findAll(pageable);
    }
    default List<T> buscar(Sort sort) {
        return this.findAll(sort);
    }

    default T crear(T datos) {
        return this.save(datos);
    }

    default List<T> crear(List<T> datos) {
        return this.saveAll(datos);
    }
    default T actualizar(T datos) {
        return this.save(datos);
    }
    default void eliminar(ID id) {
         this.deleteById(id);
    }

    default  void eliminarListaIds(){
        this.deleteAll();
    }
    default void eliminarTodos(List<T> datos) {
        this.deleteAll(datos);
    }
}
