package com.example.relaciones;

import com.example.relaciones.converters.PersonaConverter;
import com.example.relaciones.models.Persona;
// import com.example.relaciones.models.Nota;
import com.example.relaciones.persistences.NotaRepository;
import com.example.relaciones.persistences.PersonaRepository;
import com.example.relaciones.services.impl.PersonaServiceImpl;
import com.example.relaciones.views.PersonaView;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


import org.mockito.Mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.when;

// import java.util.ArrayList;
// import java.util.List;

import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;






@ExtendWith(MockitoExtension.class)
public class ServiceTest {
    
    @Mock
    private PersonaRepository personaRepository;

    @Mock
    private NotaRepository notaRepository;

    @Mock
    private PersonaConverter personaConverter;

    @Mock
    private Persona persona;

    private PersonaServiceImpl underTest;

    @BeforeEach
    void setUp() {
        underTest = new PersonaServiceImpl();
        underTest.setPersonaRepository(personaRepository);
        underTest.setNotaRepository(notaRepository);
        underTest.setPersonaConverter(personaConverter);
    }

    // mvn clean ; mvn test -Dtest=ServiceTest#shouldSavePersonaSuccessfully
    @Test
    public void shouldSavePersonaSuccessfully() throws Exception {
        // given
        Persona p2 = new Persona(2L, "gabriel", "quiroz", "hombre", 45, null);
        PersonaView pV2 = new PersonaView(2L, "gabriel", "quiroz", "hombre", 45, null);

        // List<Nota> notas = new ArrayList<>();
        // notas.add(new Nota(3L,"si sabe",p2));

        // when
        when(personaConverter.toEntity(pV2, new Persona())).thenReturn(p2);
        when(personaRepository.save(any())).thenReturn(p2);

        // when(persona.getNotas()).thenReturn(notas);

        underTest.create(pV2);

        //then
        verify(personaConverter, times(1)).toEntity(any(),any());
        verify(personaRepository, times(1)).save(any());
        verify(personaConverter, times(1)).toView(any());
    }

}
