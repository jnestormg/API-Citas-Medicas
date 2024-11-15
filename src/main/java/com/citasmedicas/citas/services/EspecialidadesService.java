package com.citasmedicas.citas.services;

import java.util.List;

import com.citasmedicas.citas.entities.Especialidades;

public interface EspecialidadesService {
    
    public Especialidades GuardarEspecialidad(Especialidades especialidad);

    public List<Especialidades> MostrarEspecialidades();

    public void EliminarEspecialidad(Long id);

}
