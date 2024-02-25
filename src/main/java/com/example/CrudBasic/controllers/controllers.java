package com.example.CrudBasic.controllers;

import com.example.CrudBasic.models.Persona;
import com.example.CrudBasic.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public String update(@PathVariable Long id, @RequestBody Persona persona) {
        // Obtener la persona existente de la base de datos
        Optional<Persona> personaOptional = repositorio.findById(id);

        if (personaOptional.isPresent()) {
            // Copiar los campos relevantes de la persona recibida a la persona existente
            Persona updatePersona = personaOptional.get();
            updatePersona.setNombre(persona.getNombre());
            updatePersona.setTelefono(persona.getTelefono());

            // Guardar la persona actualizada en la base de datos
            repositorio.save(updatePersona);

            return "EDITADO CORRECTAMENTE";
        } else {
            return "No se encontró la persona con el ID proporcionado";
        }
    }


    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable Long id){
        Persona deletePersona = repositorio.findById(id).orElse(null);
        if(deletePersona != null){
            repositorio.delete(deletePersona);
            return "ELIMINADO";
        } else {
            return "No se encontró la persona con el ID proporcionado";
        }
    }

}
