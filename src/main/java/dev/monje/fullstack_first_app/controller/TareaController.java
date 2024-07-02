package dev.monje.fullstack_first_app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import dev.monje.fullstack_first_app.model.Tarea;
import dev.monje.fullstack_first_app.service.impl.TareaServiceImpl;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/v1/tareas")
public class TareaController {

    @Autowired
    private TareaServiceImpl tareaServiceImpl;

    @PostMapping
    public ResponseEntity<Tarea> create(@RequestBody Tarea tarea) {
        try {
            Tarea savedItem = tareaServiceImpl.createTarea(tarea);
            return new ResponseEntity<Tarea>(savedItem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);

        }
    }

    @PostMapping("/quantity")
    public ResponseEntity<List<Tarea>> crearVariasTareas(@RequestBody List<Tarea> tareas) {
        try {
            List<Tarea> tareasGuardadas = new ArrayList<>();
            for (Tarea tarea : tareas) {
                Tarea savedItem = tareaServiceImpl.createTarea(tarea);
                tareasGuardadas.add(savedItem);
            }
            return new ResponseEntity<>(tareasGuardadas, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
            
       
        }
    }
    @GetMapping
    public ResponseEntity<List<Tarea>> getAll() {
        try {
            final List<Tarea> tareas = new ArrayList<Tarea>();

            tareaServiceImpl.getAllTareas().forEach(tareas::add);

            if (tareas.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tareas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
       
        }
    }
  

    @GetMapping("{id}")
    public ResponseEntity<Tarea> getById(@PathVariable("id") Integer idTarea){
        Optional<Tarea> existingItemOptional = tareaServiceImpl.getTareaByIdTarea(idTarea);

        if (existingItemOptional.isPresent()) {
            return new ResponseEntity<>(existingItemOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Integer tareaId) {
        try {
            tareaServiceImpl.deleteTareaByIdTarea(tareaId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
            
        
        }
    }
    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteAll() {
        try {
            tareaServiceImpl.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
      
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Tarea> update(@PathVariable("id") Integer idTarea, @RequestBody Tarea item){
       
            Optional<Tarea> existingItemOptional = tareaServiceImpl.getTareaByIdTarea(idTarea);
            if (existingItemOptional.isPresent()) {
                Tarea existingItem = existingItemOptional.get();
                existingItem.setTituloTarea(item.getTituloTarea());
                existingItem.setDescripcionTarea(item.getDescripcionTarea());
                existingItem.setStatusTarea(item.getStatusTarea());
                tareaServiceImpl.createTarea(existingItem); // Método que actualiza la tarea en tu servicio
                return new ResponseEntity<>(existingItem, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         
            }
        
    }


}
