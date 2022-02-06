package com.example.relaciones.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "personas")
public class Persona implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apPaterno;
    private String sexo;
    private Integer edad;

    @Transient
    private List<Nota> notas;

    // el metodo de lombok hace una referencia circular ya que notas tiene un campo
    // Persona
    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre=" + nombre +
                ", apPaterno=" + apPaterno +
                ", sexo=" + sexo +
                ", edad=" + edad +
                "}";
    }
}
