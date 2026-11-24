package cl.duoc.oportunidades.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "oportunidades")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Oportunidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombre;

    private String tipo;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    private String fuente;

    private String prioridad;

    private String potencial;

    private String estado;

    @Column(columnDefinition = "TEXT")
    private String observaciones;

    @Column(name = "foto_uri")
    private String fotoUri;

    private Double latitud;

    private Double longitud;
}
