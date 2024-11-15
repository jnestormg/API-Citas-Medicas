package com.citasmedicas.citas.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;

@Entity
public class Citas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fecha;

    private String motivo;

    @JoinColumn(name = "paciente_id")
    @ManyToOne
    private Pacientes paciente;

    @JoinColumn(name = "medico_id")
    @ManyToOne
    private Medicos medico;

    @Enumerated(EnumType.STRING)
    private Estado estado;
    public enum Estado{
        PENDIENTE, CONFIRMADA, CANCELADA
    }

    @PrePersist // colocar por default el estado como confirmada
    public void asignarEstado(){
        if(estado== null ){
            estado=estado.CONFIRMADA;
        }
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public LocalDateTime getFecha() {
        return fecha;
    }
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
    public String getMotivo() {
        return motivo;
    }
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    public Pacientes getPaciente() {
        return paciente;
    }
    public void setPaciente(Pacientes paciente) {
        this.paciente = paciente;
    }
    public Estado getEstado() {
        return estado;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    public Medicos getMedico() {
        return medico;
    }
    public void setMedico(Medicos medico) {
        this.medico = medico;
    }

    

    
}
