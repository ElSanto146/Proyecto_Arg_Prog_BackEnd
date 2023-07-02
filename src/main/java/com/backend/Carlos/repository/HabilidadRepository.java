package com.backend.Carlos.repository;

import com.backend.Carlos.model.Habilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface HabilidadRepository extends JpaRepository <Habilidad, Long>{
    
}
