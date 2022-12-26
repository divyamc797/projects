package com.divya.cloud.addressservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @GetMapping()
    public String getString(){
        try{
            int x = 5/0;
            return "abcd";
        }catch (Exception ex){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Foo Not Found", ex);
        }

    }
}
