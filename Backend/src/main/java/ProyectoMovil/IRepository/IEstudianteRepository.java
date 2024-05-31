package ProyectoMovil.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ProyectoMovil.Entity.Estudiante;

@Repository
public interface IEstudianteRepository extends JpaRepository<Estudiante, Long>{}