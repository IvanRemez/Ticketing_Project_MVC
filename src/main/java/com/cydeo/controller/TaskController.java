package com.cydeo.controller;

import com.cydeo.DTO.ProjectDTO;
import com.cydeo.DTO.TaskDTO;
import com.cydeo.service.ProjectService;
import com.cydeo.service.TaskService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/task")
public class TaskController {

    private final ProjectService projectService;
    private final UserService userService;
    private final TaskService taskService;

    public TaskController(ProjectService projectService, UserService userService, TaskService taskService) {
        this.projectService = projectService;
        this.userService = userService;
        this.taskService = taskService;
    }

    @GetMapping("/create")
    public String createTask(Model model) {
//  Form:
        model.addAttribute("task", new TaskDTO());
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("employees", userService.findEmployees());
//  Table:
        model.addAttribute("tasks", taskService.findAll());

        return "/task/create";
    }

    @PostMapping("/create")
    public String insertTask(@ModelAttribute("task") TaskDTO task) {

        taskService.save(task);

        return "redirect:/task/create";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") Long id) {

        taskService.deleteById(id);

        return "redirect:/task/create";
    }

    @GetMapping("/update/{taskId}")
    public String editTask(@PathVariable("taskId") Long taskId, Model model) {

//  Task being updated:
        model.addAttribute("task", taskService.findById(taskId));
//  Project list:
        model.addAttribute("projects", projectService.findAll());
//  Employee list:
        model.addAttribute("employees", userService.findEmployees());
//  Task list Table:
        model.addAttribute("tasks", taskService.findAll());

        return "/task/update";
    }

//    @PostMapping("/update/{taskId}")
//    public String updateTask(@PathVariable("taskId") Long taskId, TaskDTO task) {
////  New Task object's fields are set from scratch when updating
////  B/c there is no ID field, we need to capture and set ourselves
//        task.setId(taskId);
//
//        taskService.update(task);
//
//        return "redirect:/task/create";
//    }

//  same function as above ^^
//  since {id} field name is the same as in TaskDTO, Spring knows which field
//  to pass it to when updating Task object
    @PostMapping("/update/{id}")
    public String updateTask(TaskDTO task) {

        taskService.update(task);

        return "redirect:/task/create";
    }

}
