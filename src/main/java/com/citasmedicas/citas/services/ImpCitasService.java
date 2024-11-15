package com.citasmedicas.citas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citasmedicas.citas.Respositories.CitasRepository;
import com.citasmedicas.citas.entities.Citas;

import jakarta.transaction.Transactional;

@Service
public class ImpCitasService implements CitasService {

    @Autowired
    private CitasRepository repository;

    @Override
    public List<Citas> MostrarCitas() {
      return repository.findAll();
    }

    @Override
    @Transactional
    public Citas GuadarCita(Citas cita) {
        return repository.save(cita);
    }

    @Override
    @Transactional
    public void BorrarCita(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Citas BuscarCita(Long id) {
      return repository.findById(id).orElse(null);
    }

}
