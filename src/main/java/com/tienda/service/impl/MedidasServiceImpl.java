package com.tienda.service.impl;

import com.tienda.dao.MedidasDao;
import com.tienda.domain.Medidas;
import com.tienda.service.MedidasService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MedidasServiceImpl implements MedidasService{ //clase implementador, en el ejemplo del restaurante es el cocinero
    
    @Autowired
    private MedidasDao medidasDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Medidas> getMedidas() {
        var listaMedidas = medidasDao.findAll();
        return listaMedidas;
    }

    @Override
    @Transactional(readOnly = true)
    public Medidas getMedida(Medidas medidas) {
        return medidasDao.findById(medidas.getIdMedida()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Medidas medidas) {
        medidasDao.save(medidas);
    }

    @Override
    @Transactional
    public void delete(Medidas medidas) {
        medidasDao.delete(medidas);
    }
    
}
