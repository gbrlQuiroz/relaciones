package com.example.relaciones.converters;

// import java.util.ArrayList;
// import java.util.List;

import com.example.relaciones.models.Persona;
import com.example.relaciones.models.Nota;
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

        if (pV.getNotas() != null && !pV.getNotas().isEmpty()) {
            // List<Nota> notas = new ArrayList<>();
            for (NotaView nV : pV.getNotas()) {
                // notas.add(new Nota(null, nV.getDescripcion(), p));
                p.getNotas().add(new Nota(null, nV.getDescripcion(), p));
            }
        }

        return p;
    }
}
