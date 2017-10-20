package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publishers.SnapchatPublisher;

public class ZGeneration extends User {
    public ZGeneration(String name) {
        this.name = name;
        this.socialPublisher = new SnapchatPublisher();
    }
}
