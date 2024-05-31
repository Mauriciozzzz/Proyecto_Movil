package ProyectoMovil.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProyectoMovil.Entity.Asistencia;
import ProyectoMovil.IRepository.IAsistenciaRepository;
import ProyectoMovil.IService.IAsistenciaService;

@Service
public class AsistenciaService implements IAsistenciaService{

    @Autowired
    private IAsistenciaRepository iAsistenciaRepository;

    @Override
    public Asistencia save(Asistencia asistencia) {
        return iAsistenciaRepository.save(asistencia);
    }

    @Override
    public void update(Asistencia asistencia, Long id) {
        Optional<Asistencia> optional = iAsistenciaRepository.findById(id);

        //Si existe, se actualiza
        if (optional.isPresent()) {
            Asistencia asistenciaUpdate = optional.get();
            asistenciaUpdate.setEstudiante(asistencia.getEstudiante());
            asistenciaUpdate.setClase(asistencia.getClase());
            asistenciaUpdate.setStatus(asistencia.getStatus());
            iAsistenciaRepository.save(asistenciaUpdate);
        }else{
            throw new RuntimeException("No existe el registro para actualizar");
        }

    }

    @Override
    public void delete(Long id) {
        iAsistenciaRepository.deleteById(id);
    }

    @Override
    public Optional<Asistencia> findById(Long id) {
        return iAsistenciaRepository.findById(id);
    }

    @Override
    public List<Asistencia> findAll() {
        return iAsistenciaRepository.findAll();
    }
}