package com.divya.cloud.addressservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan({"com.divya.cloud.addressservice.controller", "com.divya.cloud.addressservice.service"})
//@EntityScan("com.divya.cloud.addressservice.entities")
//@EnableJpaRepositories("com.divya.cloud.addressservice.repository")
public class AddressServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AddressServiceApplication.class, args);
    }

}
