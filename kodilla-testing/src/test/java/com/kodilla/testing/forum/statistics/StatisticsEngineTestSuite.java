package com.kodilla.testing.forum.statistics;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StatisticsEngineTestSuite {


    @Test
    public void calculateAdvStatisticsNoPosts() {
        //Given
        Statistics statsMock = mock(Statistics.class);
        List<String> usersNamesMock = new ArrayList<>();
        usersNamesMock.add("Jacek");
        usersNamesMock.add("Artur");
        usersNamesMock.add("Witalij");
        usersNamesMock.add("Karol");
        when(statsMock.usersNames()).thenReturn(usersNamesMock);
        when(statsMock.postsCount()).thenReturn(0);
        when(statsMock.commentsCount()).thenReturn(4);
        StatisticsEngine seReal = new StatisticsEngine();

        StatisticsEngine seExpected = new StatisticsEngine();
        seExpected.setNumberOfUsers(4);
        seExpected.setNumberOfPosts(0);
        seExpected.setNumberOfComments(4);
        seExpected.setAveragePostsPerUser(1.0);
        seExpected.setAverageCommentsPerUser(0.0);
        seExpected.setAverageCommentsPerPost(0.0);

        //When
        seReal.calculateAdvStatistics(statsMock);
        //Then
        //System.out.println(seReal.toString());
        Assert.assertEquals(seExpected, seReal);


    }

    @Test
    public void calculateAdvStatistics1000Posts() {
        //Given
        Statistics statsMock = mock(Statistics.class);
        List<String> usersNamesMock = new ArrayList<>();
        usersNamesMock.add("Jacek");
        usersNamesMock.add("Artur");
        usersNamesMock.add("Witalij");
        usersNamesMock.add("Karol");
        when(statsMock.usersNames()).thenReturn(usersNamesMock);
        when(statsMock.postsCount()).thenReturn(1000);
        when(statsMock.commentsCount()).thenReturn(4);
        StatisticsEngine seReal = new StatisticsEngine();

        StatisticsEngine seExpected = new StatisticsEngine();
        seExpected.setNumberOfUsers(4);
        seExpected.setNumberOfPosts(1000);
        seExpected.setNumberOfComments(4);
        seExpected.setAveragePostsPerUser(1.0);
        seExpected.setAverageCommentsPerUser(250.0);
        seExpected.setAverageCommentsPerPost(0.004);

        //When
        seReal.calculateAdvStatistics(statsMock);
        //Then
        //System.out.println(seReal.toString());
        Assert.assertEquals(seExpected, seReal);
    }

    @Test
    public void calculateAdvStatisticsNoComments() {
        //Given
        Statistics statsMock = mock(Statistics.class);
        List<String> usersNamesMock = new ArrayList<>();
        usersNamesMock.add("Jacek");
        usersNamesMock.add("Artur");
        usersNamesMock.add("Witalij");
        usersNamesMock.add("Karol");
        when(statsMock.usersNames()).thenReturn(usersNamesMock);
        when(statsMock.postsCount()).thenReturn(4);
        when(statsMock.commentsCount()).thenReturn(0);
        StatisticsEngine seReal = new StatisticsEngine();

        StatisticsEngine seExpected = new StatisticsEngine();
        seExpected.setNumberOfUsers(4);
        seExpected.setNumberOfPosts(4);
        seExpected.setNumberOfComments(0);
        seExpected.setAveragePostsPerUser(0.0);
        seExpected.setAverageCommentsPerUser(1.0);
        seExpected.setAverageCommentsPerPost(0.0);

        //When
        seReal.calculateAdvStatistics(statsMock);
        //Then
        //System.out.println(seReal.toString());
        Assert.assertEquals(seExpected, seReal);
    }

    @Test
    public void calculateAdvStatisticsLessCommentsThanPosts() {
        //Given
        Statistics statsMock = mock(Statistics.class);
        List<String> usersNamesMock = new ArrayList<>();
        usersNamesMock.add("Jacek");
        usersNamesMock.add("Artur");
        usersNamesMock.add("Witalij");
        usersNamesMock.add("Karol");
        when(statsMock.usersNames()).thenReturn(usersNamesMock);
        when(statsMock.postsCount()).thenReturn(4000);
        when(statsMock.commentsCount()).thenReturn(4);
        StatisticsEngine seReal = new StatisticsEngine();

        StatisticsEngine seExpected = new StatisticsEngine();
        seExpected.setNumberOfUsers(4);
        seExpected.setNumberOfPosts(4000);
        seExpected.setNumberOfComments(4);
        seExpected.setAveragePostsPerUser(1.0);
        seExpected.setAverageCommentsPerUser(1000.0);
        seExpected.setAverageCommentsPerPost(0.001);

        //When
        seReal.calculateAdvStatistics(statsMock);
        //Then
        //System.out.println(seReal.toString());
        Assert.assertEquals(seExpected, seReal);
    }

    @Test
    public void calculateAdvStatisticsMoreCommentsThanPosts() {
        //Given
        Statistics statsMock = mock(Statistics.class);
        List<String> usersNamesMock = new ArrayList<>();
        usersNamesMock.add("Jacek");
        usersNamesMock.add("Artur");
        usersNamesMock.add("Witalij");
        usersNamesMock.add("Karol");
        when(statsMock.usersNames()).thenReturn(usersNamesMock);
        when(statsMock.postsCount()).thenReturn(4);
        when(statsMock.commentsCount()).thenReturn(4000);
        StatisticsEngine seReal = new StatisticsEngine();

        StatisticsEngine seExpected = new StatisticsEngine();
        seExpected.setNumberOfUsers(4);
        seExpected.setNumberOfPosts(4);
        seExpected.setNumberOfComments(4000);
        seExpected.setAveragePostsPerUser(1000.0);
        seExpected.setAverageCommentsPerUser(1.0);
        seExpected.setAverageCommentsPerPost(1000.0);

        //When
        seReal.calculateAdvStatistics(statsMock);
        //Then
        //System.out.println(seReal.toString());
        Assert.assertEquals(seExpected, seReal);
    }

    @Test
    public void calculateAdvStatisticsNoUsers() {
        //Given
        Statistics statsMock = mock(Statistics.class);
        List<String> usersNamesMock = new ArrayList<>();
        when(statsMock.usersNames()).thenReturn(usersNamesMock);
        when(statsMock.postsCount()).thenReturn(4);
        when(statsMock.commentsCount()).thenReturn(4);
        StatisticsEngine seReal = new StatisticsEngine();

        StatisticsEngine seExpected = new StatisticsEngine();
        seExpected.setNumberOfUsers(0);
        seExpected.setNumberOfPosts(4);
        seExpected.setNumberOfComments(4);
        seExpected.setAveragePostsPerUser(0.0);
        seExpected.setAverageCommentsPerUser(0.0);
        seExpected.setAverageCommentsPerPost(1.0);

        //When
        seReal.calculateAdvStatistics(statsMock);
        //Then
        //System.out.println(seReal.toString());
        Assert.assertEquals(seExpected, seReal);
    }

    @Test
    public void calculateAdvStatisticsSomeUsers() {
        //Given
        Statistics statsMock = mock(Statistics.class);
        List<String> usersNamesMock = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            usersNamesMock.add("Jacek");
        }
        when(statsMock.usersNames()).thenReturn(usersNamesMock);
        when(statsMock.postsCount()).thenReturn(4);
        when(statsMock.commentsCount()).thenReturn(4);

        StatisticsEngine seReal = new StatisticsEngine();

        StatisticsEngine seExpected = new StatisticsEngine();
        seExpected.setNumberOfUsers(100);
        seExpected.setNumberOfPosts(4);
        seExpected.setNumberOfComments(4);
        seExpected.setAveragePostsPerUser(0.04);
        seExpected.setAverageCommentsPerUser(0.04);
        seExpected.setAverageCommentsPerPost(1.0);

        //When
        seReal.calculateAdvStatistics(statsMock);
        //Then
        //System.out.println(seReal.toString());
        Assert.assertEquals(seExpected, seReal);
    }
}



