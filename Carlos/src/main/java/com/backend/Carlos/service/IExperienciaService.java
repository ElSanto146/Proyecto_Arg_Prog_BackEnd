package com.backend.Carlos.service;

import com.backend.Carlos.model.Experiencia;
import java.util.List;


public interface IExperienciaService {
    
    //método para traer todas las habilidades
     public List<Experiencia> verExperiencia ();
    
     //método para dar de alta una habilidad
    public void crearExperiencia (Experiencia exp);
    
    //método para borrar una persona
    public void borrarExperiencia (Long id);
    
    //método para encontrar una persona
    public Experiencia buscarExperiencia (Long id);
    
}
