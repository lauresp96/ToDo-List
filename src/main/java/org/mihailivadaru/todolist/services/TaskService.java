package org.mihailivadaru.todolist.services;

import org.mihailivadaru.todolist.models.Task;
import org.mihailivadaru.todolist.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task createNewTask(Task task){
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id){
        return taskRepository.getById(id);
    }

    public List<Task> findAllCompletedTasks(){
        return taskRepository.findByCompletedTrue();
    }

    public List<Task> findAllIncompleteTasks(){
        return taskRepository.findByCompletedFalse();
    }

    public void deleteTask(Long task){
        taskRepository.deleteById(task);
    }
    public Task updateTask(Task task){
        return taskRepository.save(task);
    }


}
