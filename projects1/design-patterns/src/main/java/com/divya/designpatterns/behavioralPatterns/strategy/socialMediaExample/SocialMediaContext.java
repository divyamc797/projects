package com.divya.designpatterns.behavioralPatterns.strategy.socialMediaExample;

public class SocialMediaContext {
    SocialMediaStrategy socialMediaStrategy;

    public void setSocialMediaStrategy(SocialMediaStrategy socialMediaStrategy) {
        this.socialMediaStrategy = socialMediaStrategy;
    }

    public void toConnect(){
        socialMediaStrategy.toConnect();
    }
}
