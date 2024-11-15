package com.citasmedicas.citas.services;

import java.util.List;

import com.citasmedicas.citas.entities.Medicos;

public interface MedicosService {

    public List<Medicos> MostrarMedicos();

    public Medicos GuardarMedicos(Medicos medico);

    public Medicos BuscarMedico(Long id);

    public void EliminarMedico(Long id);
}
