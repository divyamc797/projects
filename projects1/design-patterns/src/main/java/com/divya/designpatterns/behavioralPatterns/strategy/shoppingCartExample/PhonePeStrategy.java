package com.divya.designpatterns.behavioralPatterns.strategy.shoppingCartExample;

public class PhonePeStrategy implements PaymentStrategy {
    private String emailId;
    private String password;

    public PhonePeStrategy(String eID, String pwd) {
        this.emailId = eID;
        this.password = pwd;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + "paid with Phonepe");
    }
}
