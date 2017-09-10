package com.kodilla.testing.forum.statistics;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter(AccessLevel.PRIVATE)
@ToString

public class StatisticsEngine {
    long numberOfUsers;
    long numberOfPosts;
    long numberOfComments;
    double averagePostsPerUser;
    double averageCommentsPerUser;
    double averageCommentsPerPost;


    void calculateAdvStatistics(Statistics statistics) {
        numberOfUsers = statistics.usersNames().size();
        numberOfPosts = statistics.postsCount();
        numberOfComments = statistics.commentsCount();

        averagePostsPerUser = numberOfPosts / numberOfUsers;
        averageCommentsPerUser = numberOfComments / numberOfUsers;
        averageCommentsPerPost = numberOfComments / numberOfPosts;
    }

    String ShowStatistics() {
        return this.toString();
    }


}
