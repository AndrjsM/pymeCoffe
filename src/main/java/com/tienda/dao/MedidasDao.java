package com.tienda.dao;

import com.tienda.domain.Medidas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedidasDao  extends JpaRepository<Medidas, Long>{ //Long es el tipo de dato
    
}
