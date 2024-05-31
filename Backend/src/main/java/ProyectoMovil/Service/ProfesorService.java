package ProyectoMovil.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ProyectoMovil.Entity.Profesor;
import ProyectoMovil.IRepository.IProfesorRepository;
import ProyectoMovil.IService.IProfesorService;

@Service
public class ProfesorService implements IProfesorService {
@Autowired
    private IProfesorRepository iProfesorRepository;
    
    @Override
    @Transactional
    public Profesor save(Profesor profesor) {
        return iProfesorRepository.save(profesor);
    }

    @Override
    @Transactional
    public void update(Profesor profesor, Long id) {
        Optional<Profesor> profesorOptional = iProfesorRepository.findById(id);
        if (profesorOptional.isPresent()) {
            Profesor profesorToUpdate = profesorOptional.get();
            profesorToUpdate.setFirstName(profesor.getFirstName());
            profesorToUpdate.setLastName(profesor.getLastName());
            profesorToUpdate.setEmail(profesor.getEmail());
            profesorToUpdate.setPhone(profesor.getPhone());
            iProfesorRepository.save(profesorToUpdate);
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        iProfesorRepository.deleteById(id);
    }

    @Override
    public Optional<Profesor> findById(Long id) {
        return iProfesorRepository.findById(id);
    }

    @Override
    public List<Profesor> findAll() {
        return iProfesorRepository.findAll();
    }
}