package com.citasmedicas.citas.Respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citasmedicas.citas.entities.Horarios_Medicos;

@Repository
public interface HorariosMedicosRepository extends JpaRepository<Horarios_Medicos, Long> {

}
