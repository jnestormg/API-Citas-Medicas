package com.citasmedicas.citas.Respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citasmedicas.citas.entities.Especialidades;

@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidades, Long> {

}
