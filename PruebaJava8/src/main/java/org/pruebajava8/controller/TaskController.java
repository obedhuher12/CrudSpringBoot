package org.pruebajava8.controller;

import jakarta.validation.Valid;
import org.pruebajava8.model.Task;
import org.pruebajava8.service.TaskService;
import org.pruebajava8.service.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaskController {
    @Autowired
    private TaskService servicio;

    @Autowired
    private TaskServiceImpl servicioImpl;



    @GetMapping({"/tasks", "/"})
    public String getAllTasks(Model modelo) {
        modelo.addAttribute("task", servicio.getAllTasks());
        return "task";
    }

    @GetMapping("/tasks/register")
    public String showFormRegister(Model modelo, Task task) {
        modelo.addAttribute("task", task);
        return "create_task.html";
    }

    @GetMapping("/tasks/update/{id}")
    public String showFormUpdate (@ModelAttribute("task") Task task, @PathVariable Long id, Model modelo) {
        modelo.addAttribute("task", servicio.getTaskById(id));
        return "edit_task";
    }

    @PostMapping("/tasks")
    public String saveTask(@Valid @ModelAttribute("task") Task task, BindingResult result, Model modelo) {
        if (result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                System.out.println("Error: " + error.getDefaultMessage());
            }
            return "create_task";
        }
        servicio.saveTask(task);
        return "redirect:/tasks";
    }
    @PostMapping("/tasks/{id}")
    public String updateTask(@Valid @ModelAttribute("task") Task task, BindingResult result, @PathVariable Long id, Model modelo) {
        modelo.addAttribute("empleado", servicio.getTaskById(id));
        if (result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                System.out.println("Error: " + error.getDefaultMessage());
            }
            return "edit_task";
        }
        Task existsTask = servicio.getTaskById(id);
        existsTask.setId(id);
        existsTask.setName(task.getName());
        existsTask.setDescription(task.getDescription());
        existsTask.setStartDate(task.getStartDate());

        servicio.updateTask(existsTask);
        return "redirect:/tasks";

    }

    @GetMapping("/tasks/{id}")
    public String deleteTask(@PathVariable Long id) {
        servicio.deleteTask(id);
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/show/{id}")
    public String showTask(@PathVariable long id, Model model){
        Task task = servicio.getTaskById(id);
        if (task != null){
            model.addAttribute("task", task);
            return "showTask";
        }
        return "task";
    }
}
