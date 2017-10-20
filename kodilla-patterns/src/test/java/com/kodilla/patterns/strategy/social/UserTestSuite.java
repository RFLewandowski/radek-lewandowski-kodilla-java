package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publishers.FacebookPublisher;
import com.kodilla.patterns.strategy.social.publishers.SnapchatPublisher;
import com.kodilla.patterns.strategy.social.publishers.TwitterPublisher;
import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {

    @Test
    public void Should_testDefaultSharingStrategies() {
        //Given
        User janusz = new Millenials("Janusz");
        User seba = new YGeneration("Seba");
        User brajan = new ZGeneration("Brajan");
        //When
        String januszShares = janusz.sharePost();
        String sebaShares = seba.sharePost();
        String brajanShares = brajan.sharePost();

        //Then
        Assert.assertEquals(FacebookPublisher.USES_FACEBOOK, januszShares);
        Assert.assertEquals(TwitterPublisher.USES_TWITTER, sebaShares);
        Assert.assertEquals(SnapchatPublisher.USES_SNAPCHAT, brajanShares);
    }


    @Test
    public void Should_testIndividualSharingStrategy() {
        //Given
        User janusz = new Millenials("Janusz");
        janusz.setSocialPublisher(new SnapchatPublisher());
        //When
        String januszShares = janusz.sharePost();
        //Then
        Assert.assertEquals(SnapchatPublisher.USES_SNAPCHAT, januszShares);
    }
}