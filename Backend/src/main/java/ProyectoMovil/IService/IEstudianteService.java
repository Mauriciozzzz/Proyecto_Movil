package ProyectoMovil.IService;

import java.util.List;
import java.util.Optional;

import ProyectoMovil.Entity.Estudiante;

public interface IEstudianteService {
    Estudiante save(Estudiante estudiante);
    void update(Estudiante estudiante, Long id);
    void delete(Long id);
    Optional<Estudiante> findById(Long id);
    List<Estudiante> findAll();
}