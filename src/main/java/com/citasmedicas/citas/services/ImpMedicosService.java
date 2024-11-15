package com.citasmedicas.citas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citasmedicas.citas.Respositories.MedicosRepository;
import com.citasmedicas.citas.entities.Medicos;

import jakarta.transaction.Transactional;

@Service
public class ImpMedicosService implements MedicosService {

    @Autowired
    private MedicosRepository repository;

    @Override
    public List<Medicos> MostrarMedicos() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Medicos GuardarMedicos(Medicos medico) {
       return repository.save(medico);
    }

    @Override
    @Transactional
    public Medicos BuscarMedico(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    @jakarta.transaction.Transactional
    public void EliminarMedico(Long id) {
         repository.deleteById(id);
    }

}
