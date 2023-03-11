package com.cydeo.controller;

import com.cydeo.DTO.UserDTO;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    private final RoleService roleService;
    private final UserService userService;

    public UserController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String createUser(Model model, UserDTO userDTO) {

        model.addAttribute("user", new UserDTO());

        model.addAttribute("roles", roleService.findAll());

        model.addAttribute("users", userService.findAll());

        return "/user/create";  // GET - create.html view
    }

// ***Whichever Model attributes EACH VIEW needs, need to be added to method***

    @PostMapping("/create")
    public String insertUser(@ModelAttribute("user") UserDTO user) {

        userService.save(user);

//        model.addAttribute("user", new UserDTO());
//        model.addAttribute("roles", roleService.findAll());
//        model.addAttribute("users", userService.findAll());
//      ^^ Redirect = will be added to Model by createUser() method

        return "redirect:/user/create";  // GET - create.html view w/ updated User in User List
    }

}
