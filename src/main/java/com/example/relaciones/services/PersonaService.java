package com.example.relaciones.services;

import com.example.relaciones.views.PersonaView;

public interface PersonaService {
    PersonaView create(PersonaView pV);
    PersonaView readDetail(long id);
    PersonaView update(PersonaView pV);

}
