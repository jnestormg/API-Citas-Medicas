package com.citasmedicas.citas.entities;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Horarios_Medicos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Enumerated(EnumType.STRING)
    // private Dia dia;
    // @ElementCollection: Esta anotación es importante porque te permite almacenar
    // una lista de valores (en este caso, días de la semana) como una colección en
    // la base de datos.
    private String nombre;

    @ElementCollection
    private List<String> dia;

    private LocalTime hora_inicio;

    private LocalTime hora_salida;

    @ManyToMany(mappedBy = "id_horario")
    @JsonIgnore // Evitar la serialización infinita de la relación recursiva
    private List<Medicos> id_medico = new ArrayList<>();

    // public enum Dia{
    // LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO
    // }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(LocalTime hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public LocalTime getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(LocalTime hora_salida) {
        this.hora_salida = hora_salida;
    }

    public List<String> getDia() {
        return dia;
    }

    public void setDia(List<String> dia) {
        this.dia = dia;
    }

    public List<Medicos> getId_medico() {
        return id_medico;
    }

    public void setId_medico(List<Medicos> id_medico) {
        this.id_medico = id_medico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
