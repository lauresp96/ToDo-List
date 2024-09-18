package org.mihailivadaru.todolist.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String taskDescription;
    private Boolean completed = false;  // Inicialmente false, luego se calcula
    // Fecha de inicio de la tarea
    private LocalDateTime startDate;

    // Duración en horas
    private Long durationInHours;

    /**
     * Este método calcula si la tarea está completada en base a la duración y la fecha de inicio.
     *
     * @return boolean que indica si la tarea está completada
     */
    public boolean isTaskCompleted() {
        if (completed) {
            return true; // Si ya está marcado como completado, se mantiene como tal
        }

        // Calculamos la fecha de finalización
        LocalDateTime endDate = startDate.plusHours(durationInHours);
        // Si la fecha actual es posterior a la fecha de finalización, la tarea está completada
        return LocalDateTime.now().isAfter(endDate);
    }
}
