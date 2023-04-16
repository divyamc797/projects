package com.divya.designpatterns.creationalPatterns.builder;

/**
 * https://www.digitalocean.com/community/tutorials/builder-design-pattern-in-java
 */
public class HomeBuilderDriver {
    public static void main(String[] args) {
        Home home = Home
                .builder()
                .homeNo(123)
                .kitchen("kitchen")
                .build();
    }
}
