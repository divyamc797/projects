package com.divya.designpatterns.creationalPatterns.factoryMethod;

/**
 * In Factory pattern, we create object without exposing the creation logic to the client.
 * <p>
 * Example:  say we have a customers of type - GOLD and SILVER
 * In factory design pattern,
 * 1. we create(super class) an CustomerInterface(which has say getDiscount() method.
 * 2. We create(sub classes)- GOLDCustomer and SilverCustomer which implements CustomerInterface
 * 3. we create Factory class - ie CustomerFactory -
 *                              here we have the basic implementation without exposing the actual logic.
 *                              say we have a method - getCustomer(CustomerType customerType)
 *                              - and returns the Discount.
 *                              keep the method(getCustomer()) that returns the subclass(Gold and Silver)
 * The actual impl will be in subClasses, and the FactoryClass will just create the object.
 *
 *  Note : in Factory class
 * 1. We can keep Factory class
 *      or we can keep the method that returns the subclass as static.
 * 2. Notice that based on the input parameter,
 *      different subclass is created and returned. getCustomer() is the factory method.
 *
 */
public class FactoryDriver {
    /**
     * https://www.digitalocean.com/community/tutorials/factory-design-pattern-in-java
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Customer c = CustomerFactory.getCustomer(CustomerType.GOLD);
        System.out.println(c.toString());
    }
}
