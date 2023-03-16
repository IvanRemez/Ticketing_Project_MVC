package com.cydeo.controller;

import com.cydeo.DTO.ProjectDTO;
import com.cydeo.DTO.TaskDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/task")
public class TaskController {

    @GetMapping("/create")
    public String createTask(Model model) {

        model.addAttribute("task", new TaskDTO());

//        model.addAttribute("managers", userService.findManagers());
//
//        model.addAttribute("projects", projectService.findAll());

        return "/task/create";
    }

}
