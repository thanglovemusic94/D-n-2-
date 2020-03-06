package com.example.demo.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminHomeController {

    @GetMapping("")
    public String adminPage() {
        return "admin/index";
    }

    @GetMapping("/user")
    public String UserPage() {
        return "user/index";
    }

    @GetMapping("/product")
    public String productIndex() {
        return "admin/product";
    }

//    @GetMapping("/logout")
//    public String login() {
//        return view +"logout";
//    }

}
