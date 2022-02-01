package com.example.relaciones.views;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class NotaView implements Serializable {

    private Long id;

    private String descripcion;

    // private Persona persona;

    // @Override
    // public boolean equals(Object o) {
    // if (this == o)
    // return true;
    // if (!(o instanceof NotaView))
    // return false;
    // return id != null && id.equals(((NotaView) o).getId());
    // }

    // @Override
    // public int hashCode() {
    // return getClass().hashCode();
    // }

}
