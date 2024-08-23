package com.tienda.dao;

import com.tienda.domain.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventarioDao  extends JpaRepository<Inventario, Long>{ //Long es el tipo de dato
    
}
