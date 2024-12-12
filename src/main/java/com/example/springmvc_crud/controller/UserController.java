package com.example.springmvc_crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springmvc_crud.entity.User;
import com.example.springmvc_crud.services.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "homePage";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("user", new User());
        return "createUser";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "editUser";
    }

    @PostMapping("/edit/{id}")
    public String editUser(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        user.setId(id);
        userService.update(user);
        return "redirect:/users/list";
    }

    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/users/list";
    }
}
