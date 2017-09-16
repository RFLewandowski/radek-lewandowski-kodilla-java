package com.kodilla.stream.forumuser;

import lombok.Value;

import java.time.LocalDate;

@Value
public class ForumUser {
    int userID;
    String userName;
    char Sex; //probably enum would be better
    LocalDate birthDate;
    int publishedPostsNumber;
}
