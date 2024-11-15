package com.citasmedicas.citas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citasmedicas.citas.Respositories.HorariosMedicosRepository;
import com.citasmedicas.citas.entities.Horarios_Medicos;

import jakarta.transaction.Transactional;

@Service
public class ImpHorariosService implements HorariosService {

    @Autowired
    private HorariosMedicosRepository repository;

    @Override
    public List<Horarios_Medicos> MostrarHorarios() {
        return repository.findAll();
  
    }

    @Override
    @Transactional
    public Horarios_Medicos GuardarHorario(Horarios_Medicos horario) {
        return repository.save(horario);
      
    }

    @Override
    @Transactional
    public void EliminarHorario(Long id) {
       repository.deleteById(id);
    }

    @Override
    @Transactional
    public Horarios_Medicos BuscarHorario(Long id) {
      return repository.findById(id).orElse(null);
    }

}
