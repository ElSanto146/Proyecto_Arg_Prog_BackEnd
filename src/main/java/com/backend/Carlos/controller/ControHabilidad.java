
package com.backend.Carlos.controller;

import com.backend.Carlos.model.Habilidad;
import com.backend.Carlos.service.IHabilidadService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("habilidad")
@CrossOrigin(origins = {"https://frondend-carlos.web.app"}) 
public class ControHabilidad {
    
    @Autowired
    private IHabilidadService habiServ;
    
    @PostMapping ("/new")
    public void agregarHabilidad (@RequestBody Habilidad hab){
        habiServ.crearHabilidad(hab);
       
    }
    
    @DeleteMapping ("/delete/{id}")
    public void borrarHabilidad (@PathVariable Long id){
        habiServ.borrarHabilidad(id);
        
    }
    
    @GetMapping ("/ver") //trae una lista
    @ResponseBody
    public List<Habilidad> verHabilidad () {
        return habiServ.verHabilidad();
    }
    
    @GetMapping ("/detalle/{id}")
    public ResponseEntity<Habilidad> getById(@PathVariable("id") int id){
        int habilidad = habiServ.buscarHabilidad(Long.MIN_VALUE).getId();
            return new ResponseEntity(habilidad, HttpStatus.OK);
    }
        
    
    
    @PutMapping ("/editar/{id}")
    public Habilidad editHabilidad (@PathVariable Long id,
                                    @RequestParam ("habilidad") String nuevaHabilidad,
                                    @RequestParam ("porcentaje") int nuevoPorcentaje){
        
        //busco la habilidad
        Habilidad habi = habiServ.buscarHabilidad(id);
        
        habi.setHabilidad(nuevaHabilidad);
        habi.setPorcentaje(nuevoPorcentaje);
        
        habiServ.crearHabilidad(habi);
        //retorna el nuevo objeto
        return habi;
    }
    
    
    
    
}
