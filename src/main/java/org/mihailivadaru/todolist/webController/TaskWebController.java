package org.mihailivadaru.todolist.webController;

import org.mihailivadaru.todolist.models.Task;
import org.mihailivadaru.todolist.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TaskWebController {

    @Autowired
    private TaskService taskService;


    @GetMapping("/tasks")
    public String viewTasks(Model model) {
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "/layout/tasks";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("task", new Task());
        return "/layout/task_create";
    }

    @PostMapping("/create")
    public String createTask(@ModelAttribute Task task) {
        taskService.createNewTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "/layout/task_edit";
    }

    @PostMapping("/edit/{id}")
    public String updateTask(@PathVariable("id") Long id, @ModelAttribute Task task) {
        task.setId(id); // Asegurar que el ID esté correctamente asignado
        taskService.updateTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") Long id) {
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }
}