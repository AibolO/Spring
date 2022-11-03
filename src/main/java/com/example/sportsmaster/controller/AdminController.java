package com.example.sportsmaster.controller;

import com.example.sportsmaster.model.Users;
import com.example.sportsmaster.services.UsersDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UsersDetailsService usersDetailsService;

    public AdminController(UsersDetailsService usersDetailsService) {
        this.usersDetailsService = usersDetailsService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", usersDetailsService.findAll());
        return "admin/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", usersDetailsService.findOne(id));
        return "admin/show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") Users user) {
        return "admin/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") @Valid Users user, BindingResult bindingResult) {

        if (bindingResult.hasErrors())
            return "admin/new";

        usersDetailsService.save(user);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", usersDetailsService.findOne(id));
        return "admin/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") @Valid Users user, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "admin/edit";

        usersDetailsService.update(id, user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        usersDetailsService.delete(id);
        return "redirect:/admin";
    }
}
