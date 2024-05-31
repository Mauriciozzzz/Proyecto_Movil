package ProyectoMovil.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProyectoMovil.Entity.Clase;
import ProyectoMovil.IRepository.IClaseRepository;
import ProyectoMovil.IService.IClaseService;

@Service
public class ClaseService implements IClaseService{

    @Autowired
    private IClaseRepository iClaseRepository;

    @Override
    public Clase save(Clase clase) {
        return iClaseRepository.save(clase);
    }

    @Override
    public void update(Clase clase, Long id) {
        Optional<Clase> optional = iClaseRepository.findById(id);

        //Si existe, se actualiza
        if (optional.isPresent()) {
            Clase claseUpdate = optional.get();
            claseUpdate.setCourse(clase.getCourse());
            claseUpdate.setFecha(clase.getFecha());
            iClaseRepository.save(claseUpdate);
        }else{
            throw new RuntimeException("No existe el registro para actualizar");
        }
    }

    @Override
    public void delete(Long id) {
        iClaseRepository.deleteById(id);
    }

    @Override
    public Optional<Clase> findById(Long id) {
        return iClaseRepository.findById(id);
    }

    @Override
    public List<Clase> findAll() {
        return iClaseRepository.findAll();
    }
}