package com.cydeo.controller;

import com.cydeo.DTO.UserDTO;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
//  Form:
        model.addAttribute("user", new UserDTO());
        model.addAttribute("roles", roleService.findAll());
//  Table:
        model.addAttribute("users", userService.findAll());

        return "/user/create";  // GET - create.html view
    }

// ***Whichever Model attributes EACH VIEW needs, need to be added to method***

    @PostMapping("/create")
    public String insertUser(@Valid @ModelAttribute("user") UserDTO user,
                             BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {

            model.addAttribute("roles", roleService.findAll());
            model.addAttribute("users", userService.findAll());

            return "/user/create";
        }

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

//  User being updated:
        model.addAttribute("user", userService.findById(username));
//  Role list:
        model.addAttribute("roles", roleService.findAll());
//  User List Table:
        model.addAttribute("users", userService.findAll());

        return "/user/update";
    }
    // in DB - Save and Update is NOT the same. Therefore, need separate HTMLs and
    // Controllers for these 2 functions

    @PostMapping("/update")
    public String updateUser(@Valid @ModelAttribute("user") UserDTO user) {

        userService.update(user);

        return "redirect:/user/create";
    }

    @GetMapping("/delete/{username}")
    public String deleteUser(@PathVariable("username") String username) {

        userService.deleteById(username);

        return "redirect:/user/create";
    }

}
