package com.citasmedicas.citas.Respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citasmedicas.citas.entities.Citas;

@Repository
public interface CitasRepository extends JpaRepository<Citas, Long> {

}
