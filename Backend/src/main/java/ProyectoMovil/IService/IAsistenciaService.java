package ProyectoMovil.IService;

import java.util.List;
import java.util.Optional;
import ProyectoMovil.Entity.Asistencia;

public interface IAsistenciaService {
    Asistencia save(Asistencia asistencia);
    void update(Asistencia asistencia, Long id);
    void delete(Long id);
    Optional<Asistencia> findById(Long id);
    List<Asistencia> findAll();
}