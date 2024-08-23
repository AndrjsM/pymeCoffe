package com.tienda.service.impl;

import com.tienda.dao.ProductoAccesorioDao;
import com.tienda.domain.ProductoAccesorio;
import com.tienda.service.ProductoAccesorioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoAccesorioServiceImpl implements ProductoAccesorioService{ //clase implementador, en el ejemplo del restaurante es el cocinero
    
    @Autowired
    private ProductoAccesorioDao productoAccesorioDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<ProductoAccesorio> getProductoAccesorios() {
        var listaProductoAccesorio = productoAccesorioDao.findAll();
        return listaProductoAccesorio;
    }

    @Override
    @Transactional(readOnly = true)
    public ProductoAccesorio getProductoAccesorio(ProductoAccesorio productoAccesorio) {
        return productoAccesorioDao.findById(productoAccesorio.getIdAccesorio()).orElse(null);
    }

    @Override
    @Transactional
    public void save(ProductoAccesorio productoAccesorio) {
        productoAccesorioDao.save(productoAccesorio);
    }

    @Override
    @Transactional
    public void delete(ProductoAccesorio productoAccesorio) {
        productoAccesorioDao.delete(productoAccesorio);
    }
    
}
