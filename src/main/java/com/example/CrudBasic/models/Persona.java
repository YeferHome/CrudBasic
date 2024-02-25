package com.example.CrudBasic.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Persona {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private  long id;
    @Column
    @Getter
    @Setter
    private String nombre;
    @Column
    @Getter
    @Setter
    private String telefono;

    public void setTelefono(String telefono) {
        // Validar que el número de teléfono solo contenga dígitos
        if (telefono.matches("\\d+")) {
            this.telefono = telefono;
        } else {
            // Enviar un mensaje de error si el número de teléfono contiene caracteres no numéricos
            throw new IllegalArgumentException("El número de teléfono solo debe contener dígitos");
        }
    }

}

