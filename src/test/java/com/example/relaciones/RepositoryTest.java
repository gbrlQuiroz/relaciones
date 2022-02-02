package com.example.relaciones;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.example.relaciones.models.Nota;
import com.example.relaciones.models.Persona;
import com.example.relaciones.persistences.NotaRepository;
import com.example.relaciones.persistences.PersonaRepository;

import org.junit.jupiter.api.Test;
// import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

// import lombok.extern.slf4j.Slf4j;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

@DataJpaTest
@ActiveProfiles("test")
public class RepositoryTest {

    // private static final Logger log =
    // LoggerFactory.getLogger(RepositoryTest.class);

    @Autowired
    private PersonaRepository pr;

    @Autowired
    private NotaRepository nr;

    // mvn clean ; mvn test -Dtest=RepositoryTest#database
    @Test
    // @Transactional(readOnly = true)
    public void database() throws Exception {
        Persona persona1 = new Persona(null, "gabriel", "quiroz", "hombre", 45,null);
        Persona persona2 = new Persona(null, "lulu", "quiroz", "mujer", 44,null);
        Persona persona3 = new Persona(null, "elianid", "tolentino", "mujer", 40,null);

        // pr.save(new Persona(null, "gabriel", "quiroz", "hombre", 45));
        pr.save(persona1);
        pr.save(persona2);
        pr.save(persona3);
        nr.save(new Nota(null, "es un chingon", persona1));
        nr.save(new Nota(null, "y ya le salio esta madre", persona1));

        System.out.println("\n------todos los registros de PERSONA");
        for (Persona dato : pr.findAll()) {
            System.out.println("dato: " + dato.toString());
        }

        // System.out.println("\n------solo apellido quiroz");
        // for (Persona dato : pr.findByApPaterno("quiroz")) {
        // System.out.println(dato.toString());
        // }

        System.out.println("\n------solo apellido quiroz");
        pr.findByApPaterno("quiroz").forEach(dato -> {
            System.out.println(dato.toString());
        });

        System.out.println("\n------obtener uno");
        Persona unDato = pr.findById(3L);
        System.out.println("--->>>dato: " + unDato.toString());

        System.out.println("\n------todos los registros de NOTA");
        nr.findByPersonaIdQuery(1L).forEach(dato -> {
            System.out.println(dato.toString());
        });

        System.out.println("\n------todos los registros de NOTA");
        nr.findByPersonaId(1L).forEach(dato -> {
            System.out.println(dato.toString());
        });
    }
}
