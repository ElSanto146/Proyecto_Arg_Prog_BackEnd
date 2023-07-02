
package com.backend.Carlos.service;

import com.backend.Carlos.model.Persona;
import java.util.List;


//Se arman 4 métodos, pero sin su implementación  porque esto es una interface. En el archivo PersonaService es donde se implementan los métodos
public interface IPersonaService {
    
    public List<Persona> verPersonas ();
    
    public void crearPersona (Persona per);
    
    public void borrarPersona (Long id);
    
    public Persona buscarPersona (Long id);
    
}
