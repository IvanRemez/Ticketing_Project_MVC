package com.cydeo.controller;

import com.cydeo.DTO.UserDTO;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
//  Redirect = ^^these attributes will be added to Model by createUser() method

        return "redirect:/user/create";
        // GET - create.html view w/ updated User in User List
    }

    @GetMapping("/update/{username}")
    public String editUser(@PathVariable("username") String username, Model model) {
// Always start with return html and then check html for what attributes you need ${...}

    // user object ${user} (user who was selected to be updated)
        model.addAttribute("user", userService.findById(username));

        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("users", userService.findAll());

        return "/user/update";
    }
    // in DB - Save and Update is NOT the same. Therefore, need separate HTMLs and
    // Controllers for these 2 functions

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") UserDTO user) {

        userService.update(user);

        return "redirect:/user/create";
    }

    @GetMapping("/delete/{username}")
    public String deleteUser(@PathVariable("username") String username) {

        userService.deleteById(username);

        return "redirect:/user/create";
    }

}
