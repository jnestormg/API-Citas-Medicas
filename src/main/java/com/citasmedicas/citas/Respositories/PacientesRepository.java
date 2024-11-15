package com.citasmedicas.citas.Respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citasmedicas.citas.entities.Pacientes;

@Repository
public interface PacientesRepository extends JpaRepository <Pacientes, Long> {

}
