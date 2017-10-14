package com.kodilla.spring.forum;

import lombok.Value;
import org.springframework.stereotype.Component;

@Component
@Value
public class ForumUser {
    private String username;

    public ForumUser() {
        this.username = "John Smith";
    }
}