
package com.tienda.service;

import com.tienda.domain.ProductoAccesorio;
import java.util.List;

public interface ProductoAccesorioService {
    // Se obtiene un listado de productoAccesorios en un List
    public List<ProductoAccesorio> getProductoAccesorios();
    
   // Se obtiene un ProductoAccesorio, a partir del id de un productoAccesorio
    public ProductoAccesorio getProductoAccesorio(ProductoAccesorio productoAccesorio);
    
    // Se inserta un nuevo productoAccesorio si el id del productoAccesorio esta vacío
    // Se actualiza un productoAccesorio si el id del productoAccesorio NO esta vacío
    public void save(ProductoAccesorio productoAccesorio);
    
    // Se elimina el productoAccesorio que tiene el id pasado por parámetro
    public void delete(ProductoAccesorio productoAccesorio);
}
