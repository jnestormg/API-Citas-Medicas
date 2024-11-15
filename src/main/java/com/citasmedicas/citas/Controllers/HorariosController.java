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

import com.citasmedicas.citas.entities.Horarios_Medicos;
import com.citasmedicas.citas.services.ImpHorariosService;

@RestController
@RequestMapping("/api/hora")
@CrossOrigin(origins = "*")
public class HorariosController {

    @Autowired
    private ImpHorariosService service;

    @GetMapping("/horario")
    public ResponseEntity<List<Horarios_Medicos>> MostrarHorarios() {
        return ResponseEntity.ok(service.MostrarHorarios());
    }

    @GetMapping("/horario/{id}")
    public ResponseEntity<?> BuscarHorario(@PathVariable Long id) {
        Horarios_Medicos horaSeleccionada = service.BuscarHorario(id);
        if (horaSeleccionada == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado");
        }
        return ResponseEntity.ok(service.BuscarHorario(id));
    }

    @DeleteMapping("/horario/{id}")
    public ResponseEntity<?> EliminarHorario(@PathVariable Long id) {
        Horarios_Medicos horaSeleccionada = service.BuscarHorario(id);
        if (horaSeleccionada == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado");
        }
        service.EliminarHorario(id);
       return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
    }

    @PostMapping("/horario")
    public ResponseEntity< Horarios_Medicos> GuardarHorario(@RequestBody Horarios_Medicos horario) {
         return ResponseEntity.ok(service.GuardarHorario(horario));
    }

    @PutMapping("/horarioid/{id}")
    public ResponseEntity<?> ActualizarHorario(@RequestBody Horarios_Medicos horario, @PathVariable Long id) {

        Horarios_Medicos HorarioActualizado = service.BuscarHorario(id);

        if(HorarioActualizado ==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado");
        }
        HorarioActualizado.setDia(horario.getDia());
        HorarioActualizado.setHora_inicio(horario.getHora_inicio());
        HorarioActualizado.setHora_salida(horario.getHora_salida());
        return ResponseEntity.ok( service.GuardarHorario(horario));

    }

}
