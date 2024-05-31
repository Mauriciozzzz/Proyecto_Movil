package ProyectoMovil.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ProyectoMovil.Entity.Curso;

@Repository
public interface ICursoRepository extends JpaRepository<Curso, Long>{}