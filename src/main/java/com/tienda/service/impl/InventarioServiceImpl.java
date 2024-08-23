package com.tienda.service.impl;

import com.tienda.dao.InventarioDao;
import com.tienda.domain.Inventario;
import com.tienda.service.InventarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InventarioServiceImpl implements InventarioService{ //clase implementador, en el ejemplo del restaurante es el cocinero
    
    @Autowired
    private InventarioDao inventarioDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Inventario> getInventarios(boolean activos) {
        var listaInventario = inventarioDao.findAll();
        return listaInventario;
    }

    @Override
    @Transactional(readOnly = true)
    public Inventario getInventario(Inventario inventario) {
        return inventarioDao.findById(inventario.getIdInventario()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Inventario inventario) {
        inventarioDao.save(inventario);
    }

    @Override
    @Transactional
    public void delete(Inventario inventario) {
        inventarioDao.delete(inventario);
    }
    
}
