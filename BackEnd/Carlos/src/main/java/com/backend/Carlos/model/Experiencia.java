package com.backend.Carlos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.sql.Date;
import lombok.Getter;
import lombok.Setter;



@Getter @Setter
@Entity
public class Experiencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private Date desde;
    private Date hasta;
    private String descripcion;

    public Experiencia() {
    }

    public Experiencia(int id, Date desde, Date hasta, String descripcion) {
        this.id = id;
        this.desde = desde;
        this.hasta = hasta;
        this.descripcion = descripcion;
    }
    
    
     
    
}
