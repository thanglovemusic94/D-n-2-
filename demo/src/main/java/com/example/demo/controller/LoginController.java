//package com.example.demo.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@Controller
//@RequestMapping("/perform_login")
//public class LoginController {
//    @RequestMapping(method = RequestMethod.POST)
//    @ResponseBody
//    public String performLogin(
//            @RequestParam("username") String username,
//            @RequestParam("password") String password,
//            HttpServletRequest request, HttpServletResponse response) {
//        try {
//            request.login(username, password);
//            return "{\"status\": true}";
//        } catch (Exception e) {
//            return "{\"status\": false, \"error\": \"Bad Credentials\"}";
//        }
//    }
//}
