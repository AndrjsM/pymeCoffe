package com.tienda.service.impl;

import com.tienda.dao.ProveedorDao;
import com.tienda.domain.Proveedor;
import com.tienda.service.ProveedorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProveedorServiceImpl implements ProveedorService{ //clase implementador, en el ejemplo del restaurante es el cocinero
    
    @Autowired
    private ProveedorDao proveedorDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Proveedor> getProveedores() {
        var listaProveedores = proveedorDao.findAll();
        return listaProveedores;
    }

    @Override
    @Transactional(readOnly = true)
    public Proveedor getProveedor(Proveedor proveedor) {
        return proveedorDao.findById(proveedor.getIdProveedor()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Proveedor proveedor) {
        proveedorDao.save(proveedor);
    }

    @Override
    @Transactional
    public void delete(Proveedor proveedor) {
        proveedorDao.delete(proveedor);
    }
    
}
