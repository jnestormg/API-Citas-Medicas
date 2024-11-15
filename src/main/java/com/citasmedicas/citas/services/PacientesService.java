package com.citasmedicas.citas.services;

import java.util.List;

import com.citasmedicas.citas.entities.Pacientes;

public interface PacientesService {

    public List<Pacientes> MostrarPacientes();

    public Pacientes GuardarPaciente(Pacientes paciente);

    public Pacientes BuscarPaciente(Long id);

    public void EliminarPaciente (Long id);
    
}
