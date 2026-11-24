package cl.duoc.oportunidades.repository;

import cl.duoc.oportunidades.model.Oportunidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OportunidadRepository extends JpaRepository<Oportunidad, Integer> {

    /**
     * Trae todas las oportunidades ordenadas por id DESC (las más nuevas primero).
     * Equivalente a Room: @Query("SELECT * FROM oportunidades ORDER BY id DESC")
     */
    List<Oportunidad> findAllByOrderByIdDesc();
}
