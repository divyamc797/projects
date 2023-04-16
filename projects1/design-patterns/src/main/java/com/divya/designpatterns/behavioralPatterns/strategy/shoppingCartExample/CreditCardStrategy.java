package com.divya.designpatterns.behavioralPatterns.strategy.shoppingCartExample;

public class CreditCardStrategy implements PaymentStrategy {
    private String name;
    private String cardNumber;
    private String cvv;
    private String dateOfExpiry;

    public CreditCardStrategy(String nm, String cardNo, String cvv, String DOE) {
        this.name = nm;
        this.cardNumber = cardNo;
        this.cvv = cvv;
        this.dateOfExpiry = DOE;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + "paid with credit card");
    }
}
