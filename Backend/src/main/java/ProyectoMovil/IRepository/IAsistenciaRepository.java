package ProyectoMovil.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ProyectoMovil.Entity.Asistencia;

@Repository
public interface IAsistenciaRepository extends JpaRepository<Asistencia, Long> {}