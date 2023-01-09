package com.divya.jwtservice.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {
    private static String USER_NAME = "divya";
    private static String PASSWORD = "dscj1994";

    @PostMapping
    public boolean login(@RequestParam("username") String userName,
                         @RequestParam("password") String password) {
        return USER_NAME.equals(userName)
                && PASSWORD.equals(password);
    }
}
