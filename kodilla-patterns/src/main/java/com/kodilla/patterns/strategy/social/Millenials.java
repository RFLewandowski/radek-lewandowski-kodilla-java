package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publishers.FacebookPublisher;

public class Millenials extends User {
    public Millenials(String name) {
        super(name);
        this.setSocialPublisher(new FacebookPublisher());
    }
}
