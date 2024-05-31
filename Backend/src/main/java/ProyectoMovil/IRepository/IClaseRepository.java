package ProyectoMovil.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ProyectoMovil.Entity.Clase;

@Repository
public interface IClaseRepository extends JpaRepository<Clase, Long>{}