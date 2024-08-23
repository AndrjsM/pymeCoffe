
package com.tienda.service;

import com.tienda.domain.Inventario;
import java.util.List;

public interface InventarioService {
    // Se obtiene un listado de inventarios en un List
    public List<Inventario> getInventarios(boolean activos);
    
   // Se obtiene un Inventario, a partir del id de un inventario
    public Inventario getInventario(Inventario inventario);
    
    // Se inserta un nuevo inventario si el id del inventario esta vacío
    // Se actualiza un inventario si el id del inventario NO esta vacío
    public void save(Inventario inventario);
    
    // Se elimina el inventario que tiene el id pasado por parámetro
    public void delete(Inventario inventario);
}
