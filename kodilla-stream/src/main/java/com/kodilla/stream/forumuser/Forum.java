package com.kodilla.stream.forumuser;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class Forum {

    private final List<ForumUser> forumUsers;

    public List<ForumUser> getUserList() {
        return new ArrayList<>(forumUsers);
    }
}
