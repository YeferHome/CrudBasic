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

}

