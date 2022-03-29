package com.example.relaciones.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.relaciones.converters.PersonaConverter;
import com.example.relaciones.models.Nota;
import com.example.relaciones.models.Persona;
import com.example.relaciones.persistences.NotaRepository;
import com.example.relaciones.persistences.PersonaRepository;
import com.example.relaciones.services.PersonaService;
import com.example.relaciones.views.NotaView;
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
        if (pV.getNotas() != null && !pV.getNotas().isEmpty()) {
            List<Nota> notas = new ArrayList<>();

            pV.getNotas().forEach(dato -> {
                notas.add(notaRepository.save(new Nota(null, dato.getDescripcion(), p)));
            });

            p.setNotas(notas);
        }

        return personaConverter.toView(p);
    }

    @Override
    public PersonaView readDetail(long id) {

        if (!personaRepository.existsById(id)) {
            return null;
        }

        Persona p = personaRepository.getById(id);

        List<Nota> notas = new ArrayList<>();
        notaRepository.findByPersonaId(id).forEach(dato -> {
            notas.add(dato);
        });

        p.setNotas(notas);

        return personaConverter.toView(p);
    }

    @Transactional(readOnly = false, rollbackFor = { Exception.class })
    @Override
    public PersonaView update(PersonaView pV) {

        long id = pV.getId();

        if (!personaRepository.existsById(id)) {
            return null;
        }

        // --- obtener entity Persona junto con sus Notas
        Persona p = personaRepository.findById(id);

        // --- quitamos la relacion para preparar la eliminacion de los que no esten en
        // el View
        List<Nota> erase = notaRepository.findByPersonaId(id);
        for (Nota n : erase) {
            n.setPersona(null);
        }

        // --- manipulacion de las notas (entidad hija)
        List<Nota> notas = new ArrayList<>();
        for (NotaView nV : pV.getNotas()) {
            Nota nota;
            // --- si vienen nuevas notas en el view
            if (nV.getId() == null) {
                nota = new Nota(null, nV.getDescripcion(), p);
                notas.add(notaRepository.save(nota));

                // --- modificar las notas existentes
            } else {
                nota = notaRepository.obtenById(nV.getId());
                nota.setDescripcion(nV.getDescripcion());
                nota.setPersona(p);
                notas.add(nota);

            }
        }

        // --- se añaden a la entidad padre
        p.setNotas(null);
        p.setNotas(notas);

        // --- se borran las notas que no esten en el View
        notaRepository.deleteByPersonaIdIsNull();

        // --- se actualizan los valores de la entidad padre
        p = personaConverter.toEntity(pV, p);

        personaRepository.save(p);

        return personaConverter.toView(p);
    }

}
