package com.tienda.dao;

import com.tienda.domain.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProveedorDao  extends JpaRepository<Proveedor, Long>{ //Long es el tipo de dato
    
}
