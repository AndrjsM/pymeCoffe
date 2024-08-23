package com.tienda.dao;

import com.tienda.domain.ProductoAccesorio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoAccesorioDao  extends JpaRepository<ProductoAccesorio, Long>{ //Long es el tipo de dato
    
}
