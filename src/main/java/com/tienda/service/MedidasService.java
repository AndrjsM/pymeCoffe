
package com.tienda.service;

import com.tienda.domain.Medidas;
import java.util.List;

public interface MedidasService {
    // Se obtiene un listado de medidass en un List
    public List<Medidas> getMedidas();
    
   // Se obtiene un Medida, a partir del id de un medidas
    public Medidas getMedida(Medidas medidas);
    
    // Se inserta un nuevo medidas si el id del medidas esta vacío
    // Se actualiza un medidas si el id del medidas NO esta vacío
    public void save(Medidas medidas);
    
    // Se elimina el medidas que tiene el id pasado por parámetro
    public void delete(Medidas medidas);
}
