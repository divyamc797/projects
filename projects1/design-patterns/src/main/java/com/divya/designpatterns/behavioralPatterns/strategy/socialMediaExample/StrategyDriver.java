package com.divya.designpatterns.behavioralPatterns.strategy.socialMediaExample;

public class StrategyDriver {
    /**
     * Strategy pattern is used when we have multiple algorithm for a specific task
     * and client decides the actual implementation to be used at runtime.
     * Example : https://www.digitalocean.com/community/tutorials/strategy-design-pattern-in-java-example-tutorial
     * @param args
     */
    public static void main(String[] args){
        SocialMediaContext socialMediaContext = new SocialMediaContext();

        socialMediaContext.setSocialMediaStrategy(new FacebookStrategy());
        socialMediaContext.toConnect();

        socialMediaContext.setSocialMediaStrategy(new TwitterStrategy());
        socialMediaContext.toConnect();
    }
}
