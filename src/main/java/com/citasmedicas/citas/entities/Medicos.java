package com.citasmedicas.citas.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Medicos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private DatosPersonales datos_personales;

    private String cedula;

    @Embedded
    private Direccion direccion;

    @JoinColumn(name = "id_especialidad")
    @ManyToOne
    private Especialidades id_especialidad;

    @ManyToMany

      @JoinTable(
        name = "medico_horarios", 
        joinColumns = @JoinColumn(name = "medico_id"), 
        inverseJoinColumns = @JoinColumn(name = "horario_id")
    )
    private List< Horarios_Medicos> id_horario= new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DatosPersonales getDatos_personales() {
        return datos_personales;
    }

    public void setDatos_personales(DatosPersonales datos_personales) {
        this.datos_personales = datos_personales;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Especialidades getId_especialidad() {
        return id_especialidad;
    }

    public void setId_especialidad(Especialidades id_especialidad) {
        this.id_especialidad = id_especialidad;
    }

    public List<Horarios_Medicos> getId_horario() {
        return id_horario;
    }

    public void setId_horario(List<Horarios_Medicos> id_horario) {
        this.id_horario = id_horario;
    }

 


    
    
    

}
