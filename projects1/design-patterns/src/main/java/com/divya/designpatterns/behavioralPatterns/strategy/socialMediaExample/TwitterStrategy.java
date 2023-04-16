package com.divya.designpatterns.behavioralPatterns.strategy.socialMediaExample;

import com.divya.designpatterns.behavioralPatterns.strategy.socialMediaExample.SocialMediaStrategy;

public class TwitterStrategy implements SocialMediaStrategy {
    @Override
    public void toConnect() {
        System.out.println("connecting to twitter");
    }
}
