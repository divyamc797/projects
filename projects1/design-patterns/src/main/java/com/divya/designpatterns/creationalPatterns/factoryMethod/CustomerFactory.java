package com.divya.designpatterns.creationalPatterns.factoryMethod;

public class CustomerFactory {

//    public Customer getGoldCustomer() {
//        return new GoldCustomer();
//    }
//
//    public Customer getSilverCustomer() {
//        return new SilverCustomer();
//    }

    public static Customer getCustomer(CustomerType customerType) throws Exception {
        switch (customerType) {
            case GOLD:
                return new GoldCustomer();
            case SILVER:
                return new SilverCustomer();
        }
        throw new Exception("Invalid customer type");
    }
}
