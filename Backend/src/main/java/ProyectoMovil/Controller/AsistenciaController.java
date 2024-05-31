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

import ProyectoMovil.Entity.Asistencia;
import ProyectoMovil.Service.AsistenciaService;

@RestController
@RequestMapping("/asistencia")
@CrossOrigin(origins = "*")
public class AsistenciaController {
    @Autowired
    private AsistenciaService asistenciaService;

    @PostMapping("")
    public Asistencia save(@RequestBody Asistencia Asistencia){
         return asistenciaService.save(Asistencia);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Asistencia Asistencia, @PathVariable Long id){
        asistenciaService.update(Asistencia, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        asistenciaService.delete(id);
    }

    @GetMapping("")
    public List<Asistencia> findAll(){
        return asistenciaService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Asistencia> findById(@PathVariable Long id){
        return asistenciaService.findById(id);
    }
}