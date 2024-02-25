package com.example.CrudBasic.controllers;

import com.example.CrudBasic.models.Persona;
import com.example.CrudBasic.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class controllers {
    @Autowired
    private Repository repositorio;

    @GetMapping()
    public String index(){
        return "CONECTADO";
    }
    @GetMapping("personas")
    public List<Persona> getPersonas(){
        return repositorio.findAll();
    }

    @PostMapping("grabar")
    public String post(@RequestBody Persona persona){
        repositorio.save(persona);
        return "GRABADO";
    }

    @PutMapping("editar/{id}")
    public String update(@PathVariable Long id,@RequestBody Persona persona){
    Persona updatePersona = repositorio.findById(id).get();
    updatePersona.setNombre(persona.getNombre());
    updatePersona.setTelefono(persona.getTelefono());
    repositorio.save(updatePersona);
    return "EDITADO CORRECTAMENTE";
    }

    @DeleteMapping("delete/¨{id}")
    public String delete(@PathVariable Long id){
        Persona deletePersona = repositorio.findById(id).get();
        repositorio.delete(deletePersona);
        return "ELIMINADO";
    }

}
