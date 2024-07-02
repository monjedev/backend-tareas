package dev.monje.fullstack_first_app.record;

import dev.monje.fullstack_first_app.enums.StatusTarea;

public record TareaDto(Integer idTarea, String tituloTarea, String descripcionTarea, StatusTarea statusTarea) {
    
}
