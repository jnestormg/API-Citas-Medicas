package com.citasmedicas.citas.Respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citasmedicas.citas.entities.Medicos;

@Repository
public interface MedicosRepository extends JpaRepository<Medicos, Long> {

    



}
