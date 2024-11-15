package com.citasmedicas.citas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citasmedicas.citas.Respositories.EspecialidadRepository;
import com.citasmedicas.citas.entities.Especialidades;

import jakarta.transaction.Transactional;

@Service
public class ImpEspecialidadService implements EspecialidadesService {

    @Autowired
    private EspecialidadRepository repository;

    @Override
    @Transactional
    public Especialidades GuardarEspecialidad(Especialidades especialidad) {
        return repository.save(especialidad);
    }

    public List<Especialidades> GuardarTodas(List<Especialidades> especialidades){
        return repository.saveAll(especialidades);
    }

    @Override
    public List<Especialidades> MostrarEspecialidades() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void EliminarEspecialidad(Long id) {
         repository.deleteById(id);
  }
    
}
