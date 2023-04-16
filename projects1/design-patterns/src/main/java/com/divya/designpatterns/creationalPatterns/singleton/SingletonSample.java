package com.divya.designpatterns.creationalPatterns.singleton;

/**
 * Singleton design pattern -
 * Class should have ony one instance.
 * ensures that only one instance of the class exists in the application.
 * Singleton pattern is used for logging, drivers objects, caching, and thread pool.
 * <p>
 * impl of singleton class
 * 1. Private constructor to restrict instantiation of the class from other classes.
 * 2. Private static variable of the same class that is the only instance of the class.
 * 3. Public static method that returns the instance of the class,
 * this is the global access point for the outer world to get the instance of the singleton class.
 * Assume we have class SingletonSample
 */
public class SingletonSample {

    private SingletonSample() {
    }

    private static SingletonSample singletonSample;

    /**
     * Thread safe method
     *
     * @return
     * Assume 2 threads comes together both ll go inside 1st if.
     */
    public static SingletonSample getInstance() { // method level lock
        if (singletonSample == null) {
            synchronized (SingletonSample.class) { // synchronized block   // threads ll wait hear
                if (singletonSample == null) {
                    singletonSample = new SingletonSample();
                }
            }
        }

        return singletonSample;
    }



    //rest of the non-static/instance methods to talk to database

    public void connectToDB() {
        System.out.println("connected to Db");
    }

    public String getSession() {
        return "session";
    }

    /*
    1. why private constructor?
       to avoid object creation outside the class. (we can create object using getInstance method.)
    2. why not method level synchronized?
       lock ll happen at method level (for each thread when they call getInstance.)
       so each time while creating object thread ll lock and again unlock the object
                                - its a costly operation(in terms of CPU utilization)
    3. why 2 if's? (or) what is the importance of inner if?
       Assume 2 threads comes together both ll go inside 1st if.
       one of them ll win the lock and creates the object and complets the execution.
       then 2nd thread ll also get the lock.
       if there is no 2nd if, again it ll create an object.
        to avoid that we need 2nd if(or double check)
        ((if object is null then only it should create object)
    4. why synchronized block instead of method level synchronized and what is the value add?
       synchronized block holds all the thread and allow only one thread to go and create object.
       since synchronized block unlock one thread at a time, 1st thread ll go and create object.
        synchronized block  ll increase cpu performance rather than method level synchronized
     */
}
