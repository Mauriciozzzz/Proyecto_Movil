package ProyectoMovil.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ProyectoMovil.Entity.Estudiante;
import ProyectoMovil.IRepository.IEstudianteRepository;
import ProyectoMovil.IService.IEstudianteService;

@Service
public class EstudianteService implements IEstudianteService{
    @Autowired
    private IEstudianteRepository iEstudianteRepository;
    
    @Override
    @Transactional
    public Estudiante save(Estudiante estudiante) {
        return iEstudianteRepository.save(estudiante);
    }

    @Override
    @Transactional //asegura que cada método se ejecute dentro de una transacción. Si el método termina con éxito, la transacción se confirma, de lo contrario, se revierte.
    public void update(Estudiante estudiante, Long id) {
        Optional<Estudiante> estudianteOptional = iEstudianteRepository.findById(id);
        if (estudianteOptional.isPresent()) {
            Estudiante estudianteToUpdate = estudianteOptional.get();
            estudianteToUpdate.setFirstName(estudiante.getFirstName());
            estudianteToUpdate.setLastName(estudiante.getLastName());
            estudianteToUpdate.setEmail(estudiante.getEmail());
            estudianteToUpdate.setPhone(estudiante.getPhone());
            iEstudianteRepository.save(estudianteToUpdate);
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        iEstudianteRepository.deleteById(id);
    }

    @Override
    public Optional<Estudiante> findById(Long id) {
        return iEstudianteRepository.findById(id);
    }

    @Override
    public List<Estudiante> findAll() {
        return iEstudianteRepository.findAll();
    }
}