package com.kodilla.spring.forum;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@lombok.Value
public class ForumUser {
    private String username;

    public ForumUser() {
        this.username = "John Smith";
    }
}
