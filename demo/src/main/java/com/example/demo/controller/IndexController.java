package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class IndexController {
    final String view = "admin/";

    @GetMapping("")
    public String homePage() {
        return view +"user";
    }

//    @GetMapping("/logout")
//    public String login() {
//        return view +"logout";
//    }


    @GetMapping("/contact")
    public String contactPage() {
        return "contact";
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }
}
