package com.kodilla.patterns.strategy.social.publishers;

import com.kodilla.patterns.strategy.social.SocialPublisher;

public class TwitterPublisher implements SocialPublisher {
    public static final String USES_TWITTER = "uses Twitter";

    @Override
    public String share() {
        return USES_TWITTER;
    }
}
