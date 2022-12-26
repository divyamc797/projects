package com.divya.rest.webservices.restfulwebservices.user;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private Integer id;
    private String name;
    private LocalDateTime birthDate;

}
