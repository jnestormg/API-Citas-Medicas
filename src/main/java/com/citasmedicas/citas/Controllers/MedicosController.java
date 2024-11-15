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

import com.citasmedicas.citas.entities.Medicos;
import com.citasmedicas.citas.services.ImpMedicosService;

@RestController
@RequestMapping("/api/med/")
@CrossOrigin(origins = "*")
public class MedicosController {

    @Autowired
    private ImpMedicosService service;

    /**
     * Muestra la lista de medicos guardados
     * @return regresa la lista de objetos 
     */
    @GetMapping("/medicos")
    public ResponseEntity< List<Medicos>> MostrarMedicos(){
        return ResponseEntity.ok(service.MostrarMedicos());
    }

    /**
     * Busca el medico por su id 
     * @param id Pasa el id del medico a buscar
     * @return
     */
    @GetMapping("/medicos/{id}")
    public ResponseEntity<?> BuscarMedico(@PathVariable Long id){
        Medicos medicoBuscado=service.BuscarMedico(id);
        if (medicoBuscado==null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado");            
        }   
        return ResponseEntity.ok( service.BuscarMedico(id));
    }

    /**
     * Guarda un medico
     * @param medico objeto de tipo medico que será almacenado
     * @return regresa mensaje de tipo 200 de confirmación 
     */
    @PostMapping("/medicos")
    public ResponseEntity<?> GuardarMedicos(@RequestBody Medicos medico){
        service.GuardarMedicos(medico);
        return ResponseEntity.ok("Doctor guardado");
    }

    /**
     * Elimina un medico por su id si lo encuentra, sino, regresa un mensaje de no encontrado
     * @param id id por el cual será buscado y eliminado
     * @return Mensaje para confirmar que ha sido eliminado
     */
    @DeleteMapping("/medicos/{id}")
    public ResponseEntity<?> EliminarMedico(@PathVariable Long id){
        Medicos medicoBuscado=service.BuscarMedico(id);
        if (medicoBuscado==null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado");            
        }
        service.EliminarMedico(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
    }

    /**
     * Actualiza los datos de un medico buscado por su id si e
     * es encontrado, sino, retorna un mensaje de 404
     * @param medico objeto a actualizar
     * @param id buscar por id
     * @return retorna objeto que ha sido modificado
     */
    @PutMapping("/medico/{id}")
    public ResponseEntity<?> ActualizarMedico(@RequestBody Medicos medico, @PathVariable Long id){
        Medicos medicoBuscado=service.BuscarMedico(id);
        if (medicoBuscado==null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado");
        }

        medicoBuscado.setCedula(medico.getCedula());
        medicoBuscado.setDatos_personales(medico.getDatos_personales());
        medicoBuscado.setDireccion(medico.getDireccion());
        medicoBuscado.setId_horario(medico.getId_horario());
        medicoBuscado.setId_especialidad(medico.getId_especialidad());

        return ResponseEntity.ok(service.GuardarMedicos(medicoBuscado));
    }
}
