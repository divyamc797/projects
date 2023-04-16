package com.divya.designpatterns.creationalPatterns.factoryMethod;

public class GoldCustomer implements Customer {
    int x;

    @Override
    /**
     *  in the compile time itself ll get to know the parent class has this method or knot
     */
    public int getDiscount() {
        return 50;
    }

    @Override
    public String toString() {
        return "{\"x\" : " + x + "}";
    }

//    @ToString  - above the class we can decorate, by default it ll give fully qualified class name
//  with package and hashcode
}
