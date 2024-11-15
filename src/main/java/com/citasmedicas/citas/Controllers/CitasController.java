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

import com.citasmedicas.citas.entities.Citas;
import com.citasmedicas.citas.services.ImpCitasService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class CitasController {

    @Autowired
    private ImpCitasService services;

    @GetMapping("/citas")
    public ResponseEntity<List<Citas>> MostrarCitas() {
        return ResponseEntity.ok(services.MostrarCitas());
    }

    @PostMapping("/citas")
    public ResponseEntity<Citas> GuardarCita(@RequestBody Citas cita) {
        return ResponseEntity.status(HttpStatus.CREATED).body(services.GuadarCita(cita));
    }

    @DeleteMapping("/citas/{id}")
    public ResponseEntity<?> EliminarCita(@PathVariable Long id) {
        Citas citaBuscada= services.BuscarCita(id);
        if (citaBuscada!=null) {
            services.BorrarCita(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado correctamente");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cita no encontrada");      
    }

    @GetMapping("/citas/{id}")
    public ResponseEntity<?> BuscarCita(@PathVariable Long id) {
        Citas citaBuscada=services.BuscarCita(id);
        if(citaBuscada==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cita no encontrada");
        }
        return ResponseEntity.ok(services.BuscarCita(id));
    }

   
    @PutMapping("/cita/{id}")
    public ResponseEntity<?> ActualizarCitas(@RequestBody Citas cita, @PathVariable Long id) {
        Citas citaEncontrada = services.BuscarCita(id);

        if (citaEncontrada == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cita no encontrada");
        }

        citaEncontrada.setEstado(cita.getEstado());
        citaEncontrada.setMotivo(cita.getMotivo());

        services.GuadarCita(citaEncontrada);
        return ResponseEntity.ok("Modificado exitosamente");
    }

}
