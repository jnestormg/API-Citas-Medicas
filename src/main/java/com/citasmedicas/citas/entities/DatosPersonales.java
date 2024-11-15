package com.citasmedicas.citas.entities;

import org.hibernate.annotations.processing.Pattern;

import jakarta.persistence.Embeddable;

@Embeddable
public class DatosPersonales {

    private String nombre;

    private String apellidos;

    private Long telefono;

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

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    

    
}
