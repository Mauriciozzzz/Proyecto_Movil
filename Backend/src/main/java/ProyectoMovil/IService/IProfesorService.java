package ProyectoMovil.IService;

import java.util.List;
import java.util.Optional;
import ProyectoMovil.Entity.Profesor;

public interface IProfesorService {
    Profesor save(Profesor profesor);
    void update(Profesor profesor, Long id);
    void delete(Long id);
    Optional<Profesor> findById(Long id);
    List<Profesor> findAll();
}