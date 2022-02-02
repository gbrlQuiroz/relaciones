package com.example.relaciones.endpoints;

import com.example.relaciones.services.PersonaService;
import com.example.relaciones.views.PersonaView;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("persona")
public class PersonaRest {

    private PersonaService personaService;

    @Autowired
    public void setPersonaService(PersonaService personaService) {
        this.personaService = personaService;
    }

    @PostMapping("")
    public ResponseEntity<PersonaView> createCity(@RequestBody PersonaView personaView) {

        PersonaView pV = personaService.create(personaView);

        return new ResponseEntity<>(pV, HttpStatus.CREATED);
    }

}
