package com.citasmedicas.citas.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citasmedicas.citas.entities.Pacientes;
import com.citasmedicas.citas.services.ImpPacientesService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class PacientesController {

    @Autowired
    private ImpPacientesService service;

    @GetMapping("/pacientes")
    public ResponseEntity< List<Pacientes>> MostrarPacientes(){
        return ResponseEntity.ok(service.MostrarPacientes());
    }

    @PostMapping("/pacientes")
    public ResponseEntity<?> GuardarPaciente(@RequestBody Pacientes paciente){
        service.GuardarPaciente(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body("Paciente guardado con exito");
    }

    @DeleteMapping("/pacientes/{id}")
    public ResponseEntity<?> BorrarPaciente(@PathVariable Long id){
        Pacientes pacienteBuscado= service.BuscarPaciente(id);
        if (pacienteBuscado==null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente no encontrado");
        }
        service.EliminarPaciente(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Paciente eliminado");
    }

    @GetMapping("/pacientes/{id}")
    public ResponseEntity< ?> BuscarPaciente(@PathVariable Long id){
        Pacientes pacienteBuscando= service.BuscarPaciente(id);
        if (pacienteBuscando==null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente no encontrado");
        }
        
         return ResponseEntity.ok( service.BuscarPaciente(id));
    }

    @PutMapping("/paciente/{id}")
    public ResponseEntity<?> ActualizarPaciente(@RequestBody Pacientes paciente, @PathVariable Long id){
        Pacientes pacienteBuscado= service.BuscarPaciente(id);

        if (pacienteBuscado==null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente no encontrado");
        }
        pacienteBuscado.setEdad(paciente.getEdad());
        pacienteBuscado.setGenero(paciente.getGenero());
        pacienteBuscado.setDatos_personales(paciente.getDatos_personales());
        pacienteBuscado.setDireccion(paciente.getDireccion());
        service.GuardarPaciente(pacienteBuscado);

        return ResponseEntity.ok("Paciente "+pacienteBuscado.getDatos_personales().getNombre()+ " modificado");
    }

}
