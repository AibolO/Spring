package com.example.sportsmaster.controller;

import com.example.sportsmaster.model.Users;
import com.example.sportsmaster.security.UsersDetails;
import com.example.sportsmaster.services.CategoryService;
import com.example.sportsmaster.services.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PagesController {
    private final TournamentService tournamentService;
    private final CategoryService categoryService;

    @Autowired
    public PagesController(TournamentService tournamentService, CategoryService categoryService) {
        this.tournamentService = tournamentService;
        this.categoryService = categoryService;
    }

    @GetMapping("/main")
    public String index(@ModelAttribute("user") Users users) {
        return "pages/main";
    }

    @GetMapping("/showUser")
    public String showUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UsersDetails usersDetails = (UsersDetails) authentication.getPrincipal();
        System.out.println(usersDetails.getUser());

        return "pages/main";
    }

    @GetMapping("/tournaments")
    public String tournaments() {
        return "pages/tournaments";
    }

    @GetMapping("/tournament")
    public String tournament() {
        return "pages/tournament";
    }

}
