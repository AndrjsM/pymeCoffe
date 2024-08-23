
package com.tienda.service;

import com.tienda.domain.Proveedor;
import java.util.List;

public interface ProveedorService {
    // Se obtiene un listado de proveedors en un List
    public List<Proveedor> getProveedores();
    
   // Se obtiene un Proveedor, a partir del id de un proveedor
    public Proveedor getProveedor(Proveedor proveedor);
    
    public Proveedor getProveedorById(Long id);
    
    // Se inserta un nuevo proveedor si el id del proveedor esta vacío
    // Se actualiza un proveedor si el id del proveedor NO esta vacío
    public void save(Proveedor proveedor);
    
    // Se elimina el proveedor que tiene el id pasado por parámetro
    public void delete(Proveedor proveedor);
}
