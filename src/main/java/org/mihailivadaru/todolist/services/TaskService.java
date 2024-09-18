package org.mihailivadaru.todolist.services;

import org.mihailivadaru.todolist.models.Task;
import org.mihailivadaru.todolist.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    // Formato para fechas
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    /**
     * Crear una nueva tarea, asignando la fecha de inicio si no está definida.
     */
    public Task createNewTask(Task task) {
        if (task.getStartDate() == null) {
            task.setStartDate(LocalDateTime.now()); // Asignar fecha actual si no tiene
        }
        return taskRepository.save(task);
    }

    /**
     * Obtener todas las tareas y revisar si alguna ha completado su duración.
     */
    public List<Task> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();

        // Revisar si alguna tarea ha superado su duración y marcarla como completada
        tasks.forEach(task -> {
            if (!task.getCompleted() && task.isTaskCompleted()) {
                task.setCompleted(true);
                taskRepository.save(task); // Guardar la actualización
            }
        });

        return tasks;
    }

    /**
     * Obtener una tarea por ID.
     */
    public Task getTaskById(Long id) {
        return taskRepository.getById(id);
    }

    /**
     * Obtener la lista de tareas completadas.
     */
    public List<Task> findAllCompletedTasks() {
        return taskRepository.findByCompletedTrue();
    }

    /**
     * Obtener la lista de tareas incompletas.
     */
    public List<Task> findAllIncompleteTasks() {
        return taskRepository.findByCompletedFalse();
    }

    /**
     * Eliminar una tarea por ID.
     */
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    /**
     * Actualizar una tarea. Si no tiene fecha de inicio, se asigna ahora.
     */
    public Task updateTask(Task task) {
        if (task.getStartDate() == null) {
            task.setStartDate(LocalDateTime.now());
        }
        return taskRepository.save(task);
    }

    /**
     * Obtener una fecha formateada en el formato definido.
     */
    public String getFormattedStartDate(LocalDateTime dateTime) {
        if (dateTime != null) {
            return dateTime.format(dateFormatter);
        }
        return "No start date";
    }
}
