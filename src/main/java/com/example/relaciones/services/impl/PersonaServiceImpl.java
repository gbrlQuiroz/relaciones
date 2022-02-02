package com.example.relaciones.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.relaciones.converters.PersonaConverter;
import com.example.relaciones.models.Nota;
import com.example.relaciones.models.Persona;
import com.example.relaciones.persistences.NotaRepository;
import com.example.relaciones.persistences.PersonaRepository;
import com.example.relaciones.services.PersonaService;
import com.example.relaciones.views.PersonaView;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@Transactional(readOnly = true)
public class PersonaServiceImpl implements PersonaService {

    private PersonaRepository personaRepository;
    private NotaRepository notaRepository;

    private PersonaConverter personaConverter;

    @Autowired
    public void setPersonaRepository(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Autowired
    public void setNotaRepository(NotaRepository notaRepository) {
        this.notaRepository = notaRepository;
    }

    @Autowired
    public void setPersonaConverter(PersonaConverter personaConverter) {
        this.personaConverter = personaConverter;
    }

    @Transactional(readOnly = false, rollbackFor = { Exception.class })
    @Override
    public PersonaView create(PersonaView pV) {

        Persona p = personaConverter.toEntity(pV, new Persona());

        // se guarda entidad principal
        personaRepository.save(p);

        // se guardan entidades relacionadas
        if (p.getNotas() != null && !p.getNotas().isEmpty()) {
            List<Nota> notas = new ArrayList<>();

            p.getNotas().forEach(dato -> {
                notas.add(notaRepository.save(new Nota(null, dato.getDescripcion(), p)));
            });

            p.setNotas(notas);
        }

        return personaConverter.toView(p);
    }

}
