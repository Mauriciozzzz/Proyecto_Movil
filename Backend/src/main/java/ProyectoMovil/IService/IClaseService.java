package ProyectoMovil.IService;

import java.util.List;
import java.util.Optional;

import ProyectoMovil.Entity.Clase;

public interface IClaseService {
    Clase save(Clase clase);
    void update(Clase clase, Long id);
    void delete(Long id);
    Optional<Clase> findById(Long id);
    List<Clase> findAll();
}