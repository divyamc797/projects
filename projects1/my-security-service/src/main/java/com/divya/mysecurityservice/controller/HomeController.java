package com.divya.mysecurityservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.Map;

@RestController
public class HomeController {
    @Autowired
    private AuthenticationManager authenticationManager;

    //best practice
    //by using Authentication -> basic auth in postman
    // (user name and password which is provided as database(I stored in service using Map.of)))
    @GetMapping("/getMyName")
    public String get(@RequestHeader Map<String, String> headers) {
        //in header we will get [authorization -> Basic ZGl2eWE6cGFzc3dvcmQ=]  . when we do -> headers.get("authorization").substring(6))
        //we will get : ZGl2eWE6cGFzc3dvcmQ=
        String userNameAndPassword = new String(Base64.getDecoder().decode(headers.get("authorization").substring(6)));
        //userNameAndPassword- divya:password
        // --> 0:1:2:3 splitting userName and password --> passing to authenticationManager's authenticate()
        String username = userNameAndPassword.split(":")[0];
        String password = userNameAndPassword.split(":")[1];
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        return "divya";
    }


    //not a best practice to send userName and password in parameters
//    @GetMapping("/getMyAge/{username}/{password}")
//    public int getAge(@PathVariable String username, @PathVariable String password) {
//        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//        return 25;
//    }
}
