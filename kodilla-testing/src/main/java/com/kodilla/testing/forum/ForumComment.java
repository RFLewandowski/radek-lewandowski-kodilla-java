package com.kodilla.testing.forum;

import lombok.Value;

@Value
public class ForumComment {
    ForumPost forumPost;
    String commentBody;
    String author;
}
