package dev.monje.fullstack_first_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.monje.fullstack_first_app.model.Tarea;
import java.util.Optional;

@Repository
public interface TareaRepository extends JpaRepository<Tarea,Integer> {
    Optional<Tarea> findTareaByIdTarea(Integer idTarea);
    
}
