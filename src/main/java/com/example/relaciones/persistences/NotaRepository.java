package com.example.relaciones.persistences;

import com.example.relaciones.models.Nota;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotaRepository extends JpaRepository<Nota,Long> {

    List<Nota> findByPersonaId(long personaId);

    // @Query(value="SELECT nota FROM notas nota JOIN FETCH nota.persona WHERE nota.id = :personaId", nativeQuery = true)
    @Query(value="SELECT nota.* FROM notas nota WHERE nota.persona_id = :personaId", nativeQuery = true)
    List<Nota> findByPersonaIdQuery(Long personaId);

}
