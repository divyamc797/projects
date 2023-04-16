package com.divya.designpatterns.creationalPatterns.singleton;

/**
 * https://www.digitalocean.com/community/tutorials/java-singleton-design-pattern-best-practices-examples
 */
public class SingletonDirver {
    public static void main(String[] args) {
        SingletonSample s = SingletonSample.getInstance();
        //getInstance method ll create object
        s.getSession();
        s.connectToDB();
        SingletonSample s1 = SingletonSample.getInstance();
    }
}
