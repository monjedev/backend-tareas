package dev.monje.fullstack_first_app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.monje.fullstack_first_app.model.Tarea;
import dev.monje.fullstack_first_app.repository.TareaRepository;
import dev.monje.fullstack_first_app.service.TareaService;

@Service
public class TareaServiceImpl implements TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    @Override
    public Tarea createTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    @Override
    public void deleteTareaByIdTarea(Integer tareaId) {
        tareaRepository.deleteById(tareaId);
    }
    
    @Override
    public void deleteAll() {
        tareaRepository.deleteAll();
    }

    @Override
    public List<Tarea> getAllTareas() {
        return tareaRepository.findAll();
    }

    @Override
    public Optional<Tarea> getTareaByIdTarea(Integer idTarea) {
        return tareaRepository.findTareaByIdTarea(idTarea);
    }
    
}
