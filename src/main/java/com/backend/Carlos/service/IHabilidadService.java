
package com.backend.Carlos.service;

import com.backend.Carlos.model.Habilidad;
import java.util.List;




public interface IHabilidadService {
    
    //método para traer todas las habilidades
     public List<Habilidad> verHabilidad ();
    
     //método para dar de alta una habilidad
    public void crearHabilidad (Habilidad hab);
    
    //método para borrar una persona
    public void borrarHabilidad (Long id);
    
    //método para editar
    public Habilidad edit (Habilidad hab);
    
    //método para encontrar una persona
    public Habilidad buscarHabilidad (Long id);
       
    
}
