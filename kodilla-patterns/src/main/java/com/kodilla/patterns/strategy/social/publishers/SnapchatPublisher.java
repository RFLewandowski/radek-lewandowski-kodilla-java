package com.kodilla.patterns.strategy.social.publishers;

import com.kodilla.patterns.strategy.social.SocialPublisher;

public class SnapchatPublisher implements SocialPublisher {
    public static final String USES_SNAPCHAT = "uses Snapchat";

    @Override
    public String share() {
        return USES_SNAPCHAT;
    }
}
