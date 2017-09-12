package com.kodilla.testing.forum.statistics;

import lombok.NonNull;

import java.util.List;

public interface Statistics {
    @NonNull
    List<String> usersNames(); // list of users names
    int postsCount();          // total quantity of forum posts
    int commentsCount();       // total quantity of forum comments
}