package ProyectoMovil.IService;

import java.util.List;
import java.util.Optional;
import ProyectoMovil.Entity.Curso;

public interface ICursoService {
    Curso save(Curso curso);
    void update(Curso curso, Long id);
    void delete(Long id);
    Optional<Curso> findById(Long id);
    List<Curso> findAll();
}