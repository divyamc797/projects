package com.divya.designpatterns.behavioralPatterns.strategy.socialMediaExample;

public class FacebookStrategy implements SocialMediaStrategy {
    @Override
    public void toConnect() {
        System.out.println("connecting to fb");
    }
}
