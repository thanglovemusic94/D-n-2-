package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping({"/"})
public class HomeController {

    final String view = "user/";
    final String layout = "fragment/";
    final String admin = "admin/";

    @GetMapping("")
    public String index() {
        return layout +"web";
    }

    @GetMapping("/login")
    public String login() {
        return view +"login";
    }


    @GetMapping("/about")
    public String about() {
        return "about";
    }

}
