package com.example.relaciones;

// import com.example.relaciones.models.Nota;
// import com.example.relaciones.models.Persona;
// import com.example.relaciones.persistences.NotaRepository;
// import com.example.relaciones.persistences.PersonaRepository;
// import org.springframework.context.annotation.Bean;
// import org.springframework.boot.CommandLineRunner;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class RelacionesApplication {

	// private static final Logger log = LoggerFactory.getLogger(RelacionesApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RelacionesApplication.class, args);
	}

	// @Bean
	// public CommandLineRunner demo(PersonaRepository pr, NotaRepository nr) {
	// 	return (args) -> {
	// 		Persona persona1 = new Persona(null, "gabriel", "quiroz", "hombre", 45);
	// 		Persona persona2 = new Persona(null, "lulu", "quiroz", "mujer", 44);
	// 		Persona persona3 = new Persona(null, "elianid", "tolentino", "mujer", 40);

	// 		// pr.save(new Persona(null, "gabriel", "quiroz", "hombre", 45));
	// 		pr.save(persona1);
	// 		pr.save(persona2);
	// 		pr.save(persona3);
	// 		nr.save(new Nota(null, "es un chingon", persona1));
	// 		nr.save(new Nota(null, "y ya le salio esta madre", persona1));

	// 		log.info("\n------todos los registros de PERSONA");
	// 		for (Persona dato : pr.findAll()) {
	// 			log.info(dato.toString());
	// 		}

	// 		log.info("\n------solo apellido quiroz");
	// 		for (Persona dato : pr.findByApPaterno("quiroz")) {
	// 			log.info(dato.toString());
	// 		}

	// 		log.info("\n------solo apellido quiroz");
	// 		pr.findByApPaterno("quiroz").forEach(dato -> {
	// 			log.info(dato.toString());
	// 		});

	// 		log.info("\n------obtener uno");
	// 		Persona unDato = pr.findById(3L);
	// 		log.info("{}", unDato.toString());


	// 		log.info("\n------todos los registros de NOTA");
	// 		nr.findByPersonaIdQuery(1L).forEach(dato -> {
	// 			log.info(dato.toString());
	// 		});

	// 		log.info("\n------todos los registros de NOTA");
	// 		nr.findByPersonaId(1L).forEach(dato -> {
	// 			log.info(dato.toString());
	// 		});
	// 	};

	// }

}
