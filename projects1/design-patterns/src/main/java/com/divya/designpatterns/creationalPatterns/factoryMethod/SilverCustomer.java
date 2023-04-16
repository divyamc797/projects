package com.divya.designpatterns.creationalPatterns.factoryMethod;

public class SilverCustomer implements Customer{
    @Override
    public int getDiscount() {
        return 30;
    }
}
