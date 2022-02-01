package com.example.relaciones.persistences;

import java.util.List;  

import com.example.relaciones.models.Persona;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

    List<Persona> findByApPaterno(String apPaterno);

    Persona findById(long id);
}
