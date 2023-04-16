package com.divya.designpatterns.creationalPatterns.builder;

/**
 * Builder design pattern is used to initialize the properties of the object.(at the time  of creation)
 * it is very useful when the object is very complex
 * <p>
 * if some properties are null,  need to add NULL to those properties
 * and need to maintain too many constructors as per the client requirement.
 * So, to over come these problems we can use builder patters
 * <p>
 * Builder design pattern is used to solve some problems of factory design pattern
 * 1.Too Many arguments to pass from client program to the Factory class(its hard to maintain the order)
 * 2.Some of the parameters might be optional but in Factory pattern, we are forced to send all the parameters
 * 3.If the object is heavy and its creation is complex, then all that complexity will be part of Factory classes that is confusing.
 *
 * How to create Builder design pattern?
 * 1. First of all you need to create a static nested class and define all the properties which are in outer class.
 * and then copy all the arguments from the outer class to the Builder class.
 * We should follow the naming convention
 * and if the class name is Home then builder class should be named as HomeBuilder.
 * 2. create methods to all the properties to set all the properties.
 * 3. write build method which returns actual(Home) object
 *    write constructor to initialize the actual properties from builder
 * 4. provide builder method which returns inner class object / HomeBuilder object.
 */
public class Home {
    private int homeNo;
    private String kitchen;
    private String bathRoom;
    private String livingRoom;
    private String swimmingPool;

    //3. constructor to initialize the actual properties from builder
    public Home(HomeBuilder homeBuilder) {
        this.homeNo = homeBuilder.homeNo;
        this.kitchen = homeBuilder.kitchen;
    }

    //4. provide builder method which returns inner class object / homeBuilder object
    public static HomeBuilder builder() {
        return new HomeBuilder();
    }

    //1. create static inner Builder class with the same properties
    static class HomeBuilder {
        private int homeNo;
        private String kitchen;
        private String bathRoom;
        private String livingRoom;
        private String swimmingPool;

        //2. create methods for all the properties like below, which returns builder object
        public HomeBuilder homeNo(int houseNo) {
            this.homeNo = houseNo;
            return this;
        }

        public HomeBuilder kitchen(String kitchen) {
            this.kitchen = kitchen;
            return this;
        }

        //3. write build method which returns actual(Home) object - by calling inner class object
        //                              this - refers to inner class object
        public Home build() {
            return new Home(this);
        }
    }
}
