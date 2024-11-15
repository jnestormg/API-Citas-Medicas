package com.citasmedicas.citas.Controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citasmedicas.citas.entities.Especialidades;
import com.citasmedicas.citas.services.ImpEspecialidadService;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/especialidades")
@CrossOrigin(origins = "*")
public class EspecialidadesController {

    @Autowired
    private ImpEspecialidadService service;

    @PostConstruct
    public void init() {
        List<Especialidades> especialidades = Arrays.asList(
                new Especialidades("Cardiología", "Enfermedades del corazón"),
                new Especialidades("Endocrinología", "Trastornos hormonales y metabólicos"),
                new Especialidades("Neumología", "Enfermedades pulmonares"),
                new Especialidades("Hepatología", "Enfermedades del hígado"),
                new Especialidades("Reumatología", "Enfermedades autoinmunes y articulares")

                );

        service.GuardarTodas(especialidades);
    }

    @GetMapping("/mostrar")
    public ResponseEntity<List<Especialidades>> MostrarEspecialidades() {
        return ResponseEntity.ok(service.MostrarEspecialidades());
    }

    @PostMapping("/guardar")
    public ResponseEntity<Especialidades> GuardarEspecialidad(@RequestBody Especialidades especialidad) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.GuardarEspecialidad(especialidad));
    }
}
