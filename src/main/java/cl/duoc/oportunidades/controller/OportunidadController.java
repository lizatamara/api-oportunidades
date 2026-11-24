package cl.duoc.oportunidades.controller;

import cl.duoc.oportunidades.model.Oportunidad;
import cl.duoc.oportunidades.service.OportunidadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/oportunidades")
@CrossOrigin(origins = "*") // Habilita CORS para peticiones desde Android Studio (emulador o dispositivo real)
public class OportunidadController {

    private final OportunidadService service;

    public OportunidadController(OportunidadService service) {
        this.service = service;
    }

    /**
     * GET /api/oportunidades
     * Trae todas las oportunidades ordenadas descendentemente por ID.
     */
    @GetMapping
    public ResponseEntity<List<Oportunidad>> obtenerTodas() {
        return ResponseEntity.ok(service.obtenerTodas());
    }

    /**
     * GET /api/oportunidades/{id}
     * Busca una oportunidad por su ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Oportunidad> obtenerPorId(@PathVariable Integer id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * POST /api/oportunidades
     * Crea y guarda una nueva oportunidad.
     */
    @PostMapping
    public ResponseEntity<Oportunidad> insertar(@RequestBody Oportunidad oportunidad) {
        oportunidad.setId(null); // Asegura que el ID sea auto-generado por la base de datos
        Oportunidad guardada = service.guardar(oportunidad);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardada);
    }

    /**
     * PUT /api/oportunidades/{id}
     * Modifica una oportunidad existente.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Oportunidad> actualizar(@PathVariable Integer id, @RequestBody Oportunidad oportunidad) {
        return service.actualizar(id, oportunidad)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * DELETE /api/oportunidades/{id}
     * Elimina una oportunidad por su ID.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        boolean eliminado = service.eliminar(id);
        if (eliminado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
