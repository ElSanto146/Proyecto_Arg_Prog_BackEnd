
package com.backend.Carlos.controller;

import com.backend.Carlos.model.Experiencia;
import com.backend.Carlos.service.IExperienciaService;
import java.sql.Date;
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
@RequestMapping("experiencia")
@CrossOrigin(origins = {"https://frondend-carlos.web.app"}) 
public class ControllerExperiencia {
    
    
    @Autowired
    private IExperienciaService expServ;
    
    @PostMapping ("/new")
    public void agregarExperiencia (@RequestBody Experiencia exp){
        expServ.crearExperiencia(exp);
       
    }
    
    @DeleteMapping ("/delete/{id}")
    public void borrarExperiencia (@PathVariable Long id){
        expServ.borrarExperiencia(id);
        
    }
    
    @GetMapping ("/ver") //trae una lista
    @ResponseBody
    public List<Experiencia> verExperiencia () {
        return expServ.verExperiencia();
    }
    
    @GetMapping ("/detalle/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        int experiencia = expServ.buscarExperiencia(Long.MIN_VALUE).getId();
            return new ResponseEntity(experiencia, HttpStatus.OK);
    }
        
    
    
    @PutMapping ("/editar/{id}")
    public Experiencia editExperiencia (@PathVariable Long id,
                                        @RequestParam ("desde") Date nuevoDesde,
                                        @RequestParam ("hasta") Date nuevoHasta,
                                        @RequestParam ("descripcion") String nuevaDescripcion){
        
        //busco la expilidad
        Experiencia exp = expServ.buscarExperiencia(id);
        
        exp.setDesde(nuevoDesde);
        exp.setHasta(nuevoHasta);
        exp.setDescripcion(nuevaDescripcion);
        
        expServ.crearExperiencia(exp);
        //retorna el nuevo objeto
        return exp;
    }
    
}
