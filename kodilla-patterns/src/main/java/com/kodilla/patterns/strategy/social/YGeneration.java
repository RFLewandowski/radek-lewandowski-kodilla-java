package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publishers.TwitterPublisher;

public class YGeneration extends User {
    public YGeneration(String name) {
        this.name = name;
        this.socialPublisher = new TwitterPublisher();
    }
}
