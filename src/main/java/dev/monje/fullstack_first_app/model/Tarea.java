package dev.monje.fullstack_first_app.model;

import dev.monje.fullstack_first_app.enums.StatusTarea;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "tareas")
public class Tarea {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idTarea;

    
    @Column(name = "nombre_tarea", nullable = false)
    private String tituloTarea;

    @Column(name = "descripcion", nullable = false)
    private String descripcionTarea;

    @Enumerated(EnumType.STRING)
    private StatusTarea statusTarea;


}
