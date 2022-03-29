package com.example.relaciones;

import java.util.ArrayList;
import java.util.List;

import com.example.relaciones.views.NotaView;
import com.example.relaciones.views.PersonaView;

import org.junit.jupiter.api.Test; //Junit5

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

// import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.relaciones.models.Persona;
// import com.example.relaciones.persistences.NotaRepository;
import com.example.relaciones.persistences.PersonaRepository;


public class PersonaTest extends RelacionesTestConfiguration {

    @Autowired
    private PersonaRepository pr;

    // @Autowired
    // private NotaRepository nr;

    @BeforeEach
    public void setup() {
        Persona p = new Persona();
        p.setNombre("elianid");
        p.setApPaterno("tolentino");
        p.setSexo("mijer");
        p.setEdad(39);
        pr.save(p);

        // mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    // mvn clean ; mvn test -Dtest=PersonaTest#postPersona
    @Test
    public void postPersona() throws Exception {
        PersonaView pV = new PersonaView();
        pV.setNombre("gabriel");
        pV.setApPaterno("quiroz");
        pV.setSexo("hombre");
        pV.setEdad(45);

        List<NotaView> notas = new ArrayList<>();

        NotaView nV = new NotaView();
        nV.setDescripcion("ya quedo");
        notas.add(nV);

        NotaView nV2 = new NotaView();
        nV2.setDescripcion("es bien chingon");
        notas.add(nV2);

        pV.setNotas(notas);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/persona").contentType(JSON)
                        .content(MAPPER.writeValueAsString(pV)))
                .andExpect(MockMvcResultMatchers.status()
                        .isCreated())
                .andDo(MockMvcResultHandlers.print());
    }

    // mvn clean ; mvn test -Dtest=PersonaTest#getPersona
    @Test
    public void getPersona() throws Exception {
        long id = 2L;
        mockMvc.perform(
                MockMvcRequestBuilders.get("/persona/" + id))
                .andExpect(MockMvcResultMatchers.status()
                        .isOk())
                .andDo(MockMvcResultHandlers.print());

    }

    // mvn clean ; mvn test -Dtest=PersonaTest#putPersona
    @Test
    public void putPersona() throws Exception {
        long id = 1L;

        PersonaView pV = new PersonaView();
        pV.setNombre("lourdes");
        pV.setApPaterno("quiroz");
        pV.setSexo("hombre");
        pV.setEdad(44);

        List<NotaView> notas = new ArrayList<>();

        NotaView nV = new NotaView();
        nV.setDescripcion("es mi hermana");
        notas.add(nV);

        NotaView nV2 = new NotaView();
        nV2.setDescripcion("es bien chida");
        notas.add(nV2);

        pV.setNotas(notas);

        mockMvc.perform(
                MockMvcRequestBuilders.put("/persona/" + id).contentType(JSON)
                        .content(MAPPER.writeValueAsString(pV)))
                .andExpect(MockMvcResultMatchers.status()
                        .isOk())
                .andDo(MockMvcResultHandlers.print());

    }
}
