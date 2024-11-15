package com.citasmedicas.citas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citasmedicas.citas.Respositories.PacientesRepository;
import com.citasmedicas.citas.entities.Pacientes;

import jakarta.transaction.Transactional;

@Service
public class ImpPacientesService implements PacientesService {

    @Autowired
    private PacientesRepository repository;

    @Override
    public List<Pacientes> MostrarPacientes() {
      return repository.findAll();
    }

    @Override
    @Transactional
    public Pacientes GuardarPaciente(Pacientes paciente) {
        return repository.save(paciente);
    }

    @Override
    @Transactional
    public Pacientes BuscarPaciente(Long id) {
      return repository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void EliminarPaciente(Long id) {
        repository.deleteById(id);
    }

}
