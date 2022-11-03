package com.example.sportsmaster.controller;

import com.example.sportsmaster.model.Users;
import com.example.sportsmaster.services.RegistrationService;
import com.example.sportsmaster.util.UsersValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final RegistrationService registrationService;
    private final UsersValidator usersValidator;

    @Autowired
    public AuthController(RegistrationService registrationService, UsersValidator usersValidator) {
        this.registrationService = registrationService;
        this.usersValidator = usersValidator;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "auth/loginForm";
    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("user") Users users) {
        return "auth/registerForm";
    }

    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("user") @Valid Users users,
                                      BindingResult bindingResult) {
        usersValidator.validate(users, bindingResult);

        if(bindingResult.hasErrors())
            return "/auth/registerForm";

        registrationService.register(users);

        return "redirect:/auth/login";
    }
}
