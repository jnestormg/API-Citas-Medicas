package com.citasmedicas.citas.services;

import java.util.List;

import com.citasmedicas.citas.entities.Citas;

public interface CitasService {

    public List<Citas> MostrarCitas();

    public Citas GuadarCita(Citas cita);

    public void BorrarCita(Long id);

    public Citas BuscarCita(Long id);


}
