package com.amazona.store;

import com.amazona.store.model.productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProductosRepository extends JpaRepository<productos, Long> {
    @Query("SELECT p FROM productos p WHERE p.nombre=?1")
    Optional<productos> findByName(String name);

}
