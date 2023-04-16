package com.divya.designpatterns.behavioralPatterns.strategy.shoppingCartExample;

/**
 * Strategy pattern is used when we have multiple algorithm(methods) for a specific task
 * and client decides the actual implementation to be used at runtime.
 *
 * example :  we will try to implement a simple Shopping Cart where we have two payment strategies
 * - using Credit Card or using PhonePe.
 * 1. First of all we will create the interface for our strategy pattern example,
 * in our case to pay the amount passed as argument. PaymentStrategy.java
 * 2. second we will have to create concrete implementation of algorithms for payment using
 * credit/debit card or through PhonePe. CreditCardStrategy.java and PhonePeStrategy.java
 * (here 2 algorithms - CreditCard and PhonePe are used to pay then amount)
 *
 * Now our strategy pattern example algorithms are ready.
 * We can implement Shopping Cart and payment method will require input as Payment strategy. Item.java
 */
public class StrategyDriver {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();

        Item item1 = new Item("1234", 20);
        Item item2 = new Item("2345", 30);

        shoppingCart.addItem(item1);
        shoppingCart.addItem(item2);

        //pay by phonepe
        shoppingCart.pay(new PhonePeStrategy("divya@abc.com", "qwe"));

        //pay by credit card
        shoppingCart.pay(new CreditCardStrategy("divya", "123567898765", "678", "12/1/2022"));
    }
}
