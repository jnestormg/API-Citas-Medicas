package com.citasmedicas.citas.services;
import java.util.List;

import com.citasmedicas.citas.entities.*;


public interface HorariosService {

    public List<Horarios_Medicos> MostrarHorarios();

    public Horarios_Medicos GuardarHorario(Horarios_Medicos horario);

    public void EliminarHorario(Long id);

    public Horarios_Medicos BuscarHorario(Long id);
}
