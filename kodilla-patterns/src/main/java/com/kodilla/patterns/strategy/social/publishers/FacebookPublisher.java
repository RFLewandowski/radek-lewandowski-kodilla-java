package com.kodilla.patterns.strategy.social.publishers;

import com.kodilla.patterns.strategy.social.SocialPublisher;

public class FacebookPublisher implements SocialPublisher {

    public static final String USES_FACEBOOK = "uses Facebook";

    @Override
    public String share() {
        return USES_FACEBOOK;
    }
}
