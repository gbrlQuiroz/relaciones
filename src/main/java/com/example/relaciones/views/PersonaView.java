package com.example.relaciones.views;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PersonaView implements Serializable {

    private Long id;

    private String nombre;
    private String apPaterno;
    private String sexo;
    private Integer edad;

    List<NotaView> notas;
}
