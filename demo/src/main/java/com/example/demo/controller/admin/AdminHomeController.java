package com.example.demo.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/")
@RequestMapping("/admin")
public class AdminHomeController {

    @GetMapping("")
    public String adminPage() {
        return "admin/product/list";
    }

//    @GetMapping({"/",""})
//    public String index() {
//        return "admin/index";
//    }
//
//    @GetMapping({"/product","/product/list"})
//    public String product() {
//        return "admin/product/list";
//    }

//    @GetMapping("/user")
//    public String UserPage() {
//        return "user/index";
//    }
//
//    @GetMapping("/product")
//    public String productIndex() {
//        return "test";
//    }

//    @GetMapping("/logout")
//    public String login() {
//        return view +"logout";
//    }

}
