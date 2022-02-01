package com.example.relaciones.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "notas")
public class Nota implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    // @ManyToOne(fetch = FetchType.EAGER) // no es correcto, solo fue para evitrame el manejo de session proxy en la prueba
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persona_id") // no es necesario
    private Persona persona;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Nota))
            return false;
        return id != null && id.equals(((Nota) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
