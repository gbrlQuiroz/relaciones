package com.example.relaciones.endpoints;

import com.example.relaciones.services.PersonaService;
import com.example.relaciones.views.PersonaView;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ResponseEntity<PersonaView> createPersona(@RequestBody PersonaView personaView) {

        PersonaView pV = personaService.create(personaView);

        return new ResponseEntity<>(pV, HttpStatus.CREATED);
    }

    @GetMapping("{idPersona}")
    public ResponseEntity<PersonaView> readPersonaDetail(@PathVariable("idPersona") long idPersona) {

        PersonaView resp = personaService.readDetail(idPersona);

        if (resp == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(resp);
    }

    @PutMapping("{idPersona}")
    public ResponseEntity<PersonaView> updatePersona(@RequestBody PersonaView personaView, @PathVariable long idPersona) {
        
        personaView.setId(idPersona);
        return new ResponseEntity<PersonaView>(personaService.update(personaView), HttpStatus.OK);
    }
}
