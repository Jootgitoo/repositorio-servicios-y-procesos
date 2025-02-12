package com.example.proyectoMysql;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="PERSONA", schema="personas")
public class Persona implements java.io.Serializable{

    @Id
    @Column(name="ID_PERSONA")

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idPersona;

    @Column(name="NOMBRE")
    private String nombre;

    @Column(name="APELLIDOS")
    private String apellidos;

    @Column(name="DOMICILIO")
    private String domicilio;

    @Column(name="EMAIL")
    private String email;


    public Persona(){

    }

    public Persona(String nombre, String apellidos, String domicilio, String email){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.domicilio = domicilio;
        this.email = email;
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}