package dev.monje.fullstack_first_app.service;

import java.util.List;
import java.util.Optional;


import dev.monje.fullstack_first_app.model.Tarea;

public interface TareaService {
    Tarea createTarea(Tarea tarea);
    Optional<Tarea> getTareaByIdTarea(Integer idTarea);
    List<Tarea> getAllTareas();
    void deleteTareaByIdTarea(Integer idTarea);
    void deleteAll();
}
