package com.example.relaciones.converters;

import java.util.ArrayList;
import java.util.List;

import com.example.relaciones.models.Persona;
// import com.example.relaciones.models.Nota;
import com.example.relaciones.views.NotaView;
import com.example.relaciones.views.PersonaView;

import org.springframework.stereotype.Component;

@Component
public class PersonaConverter {

    public Persona toEntity(PersonaView pV, Persona p) {
        p.setNombre(pV.getNombre());
        p.setApPaterno(pV.getApPaterno());
        p.setSexo(pV.getSexo());
        p.setEdad(pV.getEdad());

        return p;
    }

    public PersonaView toView(Persona p) {
        PersonaView pV = new PersonaView();
        pV.setId(p.getId());
        pV.setNombre(p.getNombre());
        pV.setApPaterno(p.getApPaterno());
        pV.setSexo(p.getSexo());
        pV.setEdad(p.getEdad());

        if (p.getNotas() != null && !p.getNotas().isEmpty()) {
            List<NotaView> notas = new ArrayList<>();
            // for (Nota n : p.getNotas()) {
            // notas.add(new NotaView(n.getId(), n.getDescripcion()));
            // // pV.getNotas().add(new NotaView(n.getId(), n.getDescripcion()));
            // }

            p.getNotas().forEach(dato -> {
                notas.add(new NotaView(dato.getId(), dato.getDescripcion()));
            });

            pV.setNotas(notas);
        }
        return pV;
    }

}
