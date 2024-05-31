package ProyectoMovil.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ProyectoMovil.Entity.Curso;
import ProyectoMovil.Service.CursoService;

@RestController
@RequestMapping("/curso")
@CrossOrigin(origins = "*")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @PostMapping("")
    public Curso save(@RequestBody Curso Curso){
        return cursoService.save(Curso);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Curso Curso, @PathVariable Long id){
        cursoService.update(Curso, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        cursoService.delete(id);
    }

    @GetMapping("")
    public List<Curso> findAll(){
        return cursoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Curso> findById(@PathVariable Long id){
        return cursoService.findById(id);
    }
}