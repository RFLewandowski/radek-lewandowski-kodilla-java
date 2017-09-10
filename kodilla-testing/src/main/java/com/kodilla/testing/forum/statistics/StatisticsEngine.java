package com.kodilla.testing.forum.statistics;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class StatisticsEngine {

    private long numberOfUsers;
    private long numberOfPosts;
    private long numberOfComments;
    private double averagePostsPerUser;
    private double averageCommentsPerUser;
    private double averageCommentsPerPost;


    void calculateAdvStatistics(Statistics statistics) {
        numberOfUsers = statistics.usersNames().size();
        numberOfPosts = statistics.postsCount();
        numberOfComments = statistics.commentsCount();


        averagePostsPerUser = calcAveragePostsPerUser();
        averageCommentsPerUser = calcAverageCommentsPerUser();
        averageCommentsPerPost = calcAverageCommentsPerPost();
    }


    private double calcAveragePostsPerUser() {
        if (numberOfUsers == 0) {
            return 0;
        } else {
            return (double) numberOfComments / (double) numberOfUsers;
        }
    }

    private double calcAverageCommentsPerUser() {
        if (numberOfUsers == 0) {
            return 0;
        } else {
            return (double) numberOfPosts / (double) numberOfUsers;
        }
    }

    private double calcAverageCommentsPerPost() {
        if (numberOfPosts == 0) {
            return 0;
        } else {
            return (double) numberOfComments / (double) numberOfPosts;
        }
    }

    String ShowStatistics() {
        return this.toString();
    }
}
