package cl.duoc.oportunidades.service;

import cl.duoc.oportunidades.model.Oportunidad;
import cl.duoc.oportunidades.repository.OportunidadRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OportunidadService {

    private final OportunidadRepository repository;

    public OportunidadService(OportunidadRepository repository) {
        this.repository = repository;
    }

    /**
     * READ: trae todas las oportunidades (las más nuevas primero).
     */
    @Transactional(readOnly = true)
    public List<Oportunidad> obtenerTodas() {
        return repository.findAllByOrderByIdDesc();
    }

    /**
     * READ: busca una oportunidad por su id.
     */
    @Transactional(readOnly = true)
    public Optional<Oportunidad> obtenerPorId(Integer id) {
        return repository.findById(id);
    }

    /**
     * CREATE / SAVE: guarda una oportunidad nueva.
     */
    @Transactional
    public Oportunidad guardar(Oportunidad oportunidad) {
        return repository.save(oportunidad);
    }

    /**
     * UPDATE: modifica una oportunidad existente.
     */
    @Transactional
    public Optional<Oportunidad> actualizar(Integer id, Oportunidad oportunidadActualizada) {
        return repository.findById(id).map(existente -> {
            existente.setNombre(oportunidadActualizada.getNombre());
            existente.setTipo(oportunidadActualizada.getTipo());
            existente.setDescripcion(oportunidadActualizada.getDescripcion());
            existente.setFuente(oportunidadActualizada.getFuente());
            existente.setPrioridad(oportunidadActualizada.getPrioridad());
            existente.setPotencial(oportunidadActualizada.getPotencial());
            existente.setEstado(oportunidadActualizada.getEstado());
            existente.setObservaciones(oportunidadActualizada.getObservaciones());
            existente.setFotoUri(oportunidadActualizada.getFotoUri());
            existente.setLatitud(oportunidadActualizada.getLatitud());
            existente.setLongitud(oportunidadActualizada.getLongitud());
            return repository.save(existente);
        });
    }

    /**
     * DELETE: elimina una oportunidad por su id.
     */
    @Transactional
    public boolean eliminar(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
