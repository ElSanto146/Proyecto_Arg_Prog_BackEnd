
package com.backend.Carlos.service;

import com.backend.Carlos.model.Habilidad;
import com.backend.Carlos.repository.HabilidadRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HabilidadService implements IHabilidadService {
    
    @Autowired
    public HabilidadRepository habiRepo;

    @Override //crea una lista con lo que está en la base de datos
    public List<Habilidad> verHabilidad() {
      return habiRepo.findAll();
    }

    @Override
    public void crearHabilidad(Habilidad hab) {
        habiRepo.save(hab);
    }

    @Override
    public void borrarHabilidad(Long id) {
        habiRepo.deleteById(id);
    }

    @Override
    public Habilidad buscarHabilidad(Long id) {
        return habiRepo.findById(id).orElse(null);
        //Se agrega el .orElse para que devuelva un null si no se encuentra a la persona
    }

    @Override
    public Habilidad edit(Habilidad hab) {
        return habiRepo.save(hab);
    } 
    

  
    
}
