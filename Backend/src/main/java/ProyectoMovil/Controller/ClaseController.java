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

import ProyectoMovil.Entity.Clase;
import ProyectoMovil.Service.ClaseService;

@RestController
@RequestMapping("/clase")
@CrossOrigin(origins = "*")
public class ClaseController {
    @Autowired
    private ClaseService claseService;

    @PostMapping("")
    public Clase save(@RequestBody Clase clase){
         return claseService.save(clase);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Clase clase, @PathVariable Long id){
        claseService.update(clase, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        claseService.delete(id);
    }

    @GetMapping("")
    public List<Clase> findAll(){
        return claseService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Clase> findById(@PathVariable Long id){
        return claseService.findById(id);
    }
}