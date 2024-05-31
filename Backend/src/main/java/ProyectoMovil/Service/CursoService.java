package ProyectoMovil.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProyectoMovil.Entity.Curso;
import ProyectoMovil.IRepository.ICursoRepository;
import ProyectoMovil.IService.ICursoService;

@Service
public class CursoService implements ICursoService {

   @Autowired
    private ICursoRepository iCursoRepository;

    @Override
    public Curso save(Curso curso) {
        return iCursoRepository.save(curso);
    }

    @Override
    public void update(Curso curso, Long id) {
         Optional<Curso> optional = iCursoRepository.findById(id);

        //Si existe, se actualiza
        if (optional.isPresent()) {
            Curso cursoUpdate = optional.get();
            cursoUpdate.setName(curso.getName());
            cursoUpdate.setDescription(curso.getDescription());
            cursoUpdate.setTeacher(curso.getTeacher());
            iCursoRepository.save(cursoUpdate);
        }else{
            throw new RuntimeException("No existe el registro para actualizar");
        }
    }

    @Override
    public void delete(Long id) {
        iCursoRepository.deleteById(id);
    }

    @Override
    public Optional<Curso> findById(Long id) {
        return iCursoRepository.findById(id);
    }

    @Override
    public List<Curso> findAll() {
        return iCursoRepository.findAll();
    }
}