package com.divya.rest.webservices.restfulwebservices.helloworld;

public class HelloWorldBean {
    private String message;


    public HelloWorldBean(String message) {
        this.message=message;
    }

    public String getMessage() {
        return message;
    }

    public String setMessage(String message) {
        return this.message=message;
    }

    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "message='" + message + '\'' +
                '}';
    }
}
