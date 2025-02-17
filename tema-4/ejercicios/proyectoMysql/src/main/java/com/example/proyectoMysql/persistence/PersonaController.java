package com.example.proyectoMysql.persistence;

import com.example.proyectoMysql.Persona;
import com.example.proyectoMysql.PersonaRepository;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Entity
@EntityScan(basePackages = {"com.example.proyectoMysql"})
@RestController
@RequestMapping("/persona")
public class PersonaController {
    @Autowired
    private PersonaRepository repository;
    /**
     * Get all person list.
     *
     * @return the list
     */
    @GetMapping("/find") // GET Method for reading operation
    public List<Persona> getAllPerson() {
        return repository.findAll();
    }
}