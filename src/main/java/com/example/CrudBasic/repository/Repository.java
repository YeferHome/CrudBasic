package com.example.CrudBasic.repository;

import com.example.CrudBasic.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Persona, Long>{



}
