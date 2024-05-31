package ProyectoMovil.Controller;

import java.util.List;
import java.util.Optional;

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

import ProyectoMovil.Entity.Profesor;
import ProyectoMovil.Service.ProfesorService;

@RestController
@RequestMapping("/profesor")
@CrossOrigin(origins = "*")
public class ProfesorController {
    @Autowired
    private ProfesorService profesorService;

    @PostMapping
    public ResponseEntity<Profesor> createProfesor(@RequestBody Profesor profesor) {
        Profesor newProfesor = profesorService.save(profesor);
        if (newProfesor != null) {
            return new ResponseEntity<>(newProfesor, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profesor> updateProfesor(@RequestBody Profesor profesor, @PathVariable Long id) {
        profesorService.update(profesor, id);
        Optional<Profesor> updatedProfesor = profesorService.findById(id);
        return updatedProfesor.map(profesor1 -> new ResponseEntity<>(profesor1, HttpStatus.OK))
                              .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfesor(@PathVariable Long id) {
        profesorService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profesor> getProfesorById(@PathVariable Long id) {
        Optional<Profesor> profesor = profesorService.findById(id);
        return profesor.map(profesor1 -> new ResponseEntity<>(profesor1, HttpStatus.OK))
                       .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Profesor>> getAllProfesores() {
        List<Profesor> profesores = profesorService.findAll();
        return new ResponseEntity<>(profesores, HttpStatus.OK);
    }
}
