package ProyectoMovil.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ProyectoMovil.Entity.Profesor;

@Repository
public interface IProfesorRepository extends JpaRepository<Profesor, Long>{}