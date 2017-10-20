package com.kodilla.patterns.strategy.social;

public class User {
    private String name;
    private SocialPublisher socialPublisher;

    public User(String name) {
        this.name=name;
    }

    public void setSocialPublisher(SocialPublisher socialPublisher){
        this.socialPublisher=socialPublisher;
    }

    public String sharePost(){
        return socialPublisher.share();
    }
}
