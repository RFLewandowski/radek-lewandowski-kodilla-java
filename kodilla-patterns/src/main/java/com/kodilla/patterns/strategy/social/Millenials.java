package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publishers.FacebookPublisher;

public class Millenials extends User {
    public Millenials(String name) {
        this.name=name;
        this.socialPublisher=new FacebookPublisher();
    }
}
